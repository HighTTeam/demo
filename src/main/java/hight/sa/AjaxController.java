package hight.sa;

import hight.sa.model.DeliveryCart;
import hight.sa.model.DistributionDetailInfo;
import hight.sa.model.InventoryInfo;
import hight.sa.repository.DeliveryCartRepo;
import hight.sa.repository.DeliveryRepo;
import hight.sa.repository.DistributionDetailInfoRepo;
import hight.sa.repository.InventoryInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by gibson.luo on 2017/3/12.
 */
@RestController
public class AjaxController {

    @Autowired
    private DeliveryCartRepo deliveryCartRepo;

    @Autowired
    private InventoryInfoRepo inventoryInfoRepo;

    @Autowired
    private DeliveryRepo deliveryRepo;

    @Autowired
    private DistributionDetailInfoRepo distributionDetailInfoRepo;

    @PostMapping("/addCart")
    public ResponseEntity<?> addCart(@RequestParam(value = "distributionId") String distributionId,
                                     @RequestParam(value = "logicStoreId") String logicStoreId,
                                     @RequestParam(value = "vehicleStoreId") String vehicleStoreId,
                                     @RequestParam(value = "id") String id,
                                     @RequestParam(value = "num") int num) {

        DeliveryCart deliveryCart = deliveryCartRepo.findTheSameCommodity(distributionId, id);
        if (deliveryCart == null) {
            deliveryCartRepo.addCart(distributionId, logicStoreId, vehicleStoreId, id, num);
        } else {
            int newNum = deliveryCart.getNum() + num;
            deliveryCartRepo.modifyCart(deliveryCart.getId(), newNum);
        }

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/delCart")
    public ResponseEntity<?> delCart(@RequestParam(value = "cartId") Long cartId) {
        deliveryCartRepo.deleteCart(cartId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getCommodityCount")
    public ResponseEntity<Integer> getCommodityCount(@RequestParam("storeId") String logicStoreId,
                                                     @RequestParam("commodityId") String commodityId) {
        InventoryInfo inventoryInfo = inventoryInfoRepo.findByPk(logicStoreId, commodityId);

        return ResponseEntity.ok(inventoryInfo.getCommodityCount());
    }

    @PostMapping("/deliveryConfirm")
    public ResponseEntity<String> confirmDelivery(Map<String, Object> model,
                                                  @RequestParam(value = "distributionId") String distributionId,
                                                  @RequestParam(value = "stockInName") String stockInName,
                                                  @RequestParam(value = "stockOutName") String stockOutName) {
        List<DeliveryCart> cart = Optional.ofNullable(deliveryCartRepo.getCartList(distributionId)).orElse(Collections.emptyList());

        List<DistributionDetailInfo> infoList = cart.stream().map(item -> {
            DistributionDetailInfo info = new DistributionDetailInfo();
            info.setDistributionId(distributionId);
            info.setLogicStoreIdOutput(item.getLogicStoreId());
            info.setLogicStoreNameOutput(item.getLogicStoreName());
            info.setLogicStoreIdInput(item.getVehicleStoreId());
            info.setLogicStoreNameInput(item.getVehicleStoreName());
            info.setCommodityId(item.getCommodityId());
            info.setCommodityName(item.getCommodityName());
            info.setCommodityCount(item.getNum());
            info.setLogicStoreHeadOutput(stockOutName);
            info.setLogicStoreHeadInput(stockInName);
            return info;
        }).map(item -> {
            distributionDetailInfoRepo.create(item);
            return item;
        }).collect(Collectors.toList());
        return ResponseEntity.ok().build();
    }

}
