package hight.sa;

import hight.sa.model.DeliveryCart;
import hight.sa.model.DistributionDetailInfo;
import hight.sa.model.InventoryInfo;
import hight.sa.model.StorageDetailInfo;
import hight.sa.repository.*;
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

import static java.util.stream.Collectors.toList;

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

    @Autowired
    private StorageDetailInfoRepo storageDetailInfoRepo;

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

            InventoryInfo outputInventory = inventoryInfoRepo.findByPk(item.getLogicStoreIdOutput(), item.getCommodityId());
            InventoryInfo inputInventory = inventoryInfoRepo.findByPk(item.getLogicStoreIdInput(), item.getCommodityId());

            if (outputInventory != null) {
                inventoryInfoRepo.reduceCommodityCount(item.getLogicStoreIdOutput(), item.getCommodityId(), item.getCommodityCount());
            }
            if (inputInventory != null) {
                inventoryInfoRepo.increaseCommodityCountByUpdate(item.getLogicStoreIdInput(), item.getCommodityId(), item.getCommodityCount());
            } else {
                inventoryInfoRepo.increaseCommodityCountByInsert(item.getLogicStoreIdInput(), item.getCommodityId(), item.getCommodityCount());
            }

            return item;
        }).collect(toList());
        return ResponseEntity.ok().build();
    }


    @PostMapping("/godownEntryConfirm")
    public ResponseEntity<String> confirmGodownEntry(Map<String, Object> model,
                                                     @RequestParam(value = "distributionId") String godownEntryId,
                                                     @RequestParam(value = "wholesalerHead") String wholesalerHead,
                                                     @RequestParam(value = "motorcadeHead") String motorcadeHead,
                                                     @RequestParam(value = "storeHeadInput") String storeHeadInput) {
        List<DeliveryCart> cart = Optional.ofNullable(deliveryCartRepo.getCartList(godownEntryId)).orElse(Collections.emptyList());

        List<StorageDetailInfo> infoList = cart.stream().map(item -> {
            StorageDetailInfo info = new StorageDetailInfo();
            info.setGodownEntryId(godownEntryId);
            info.setStoreIdInput(item.getLogicStoreId());
            info.setStoreNameInput(item.getLogicStoreName());
            info.setCommodityId(item.getCommodityId());
            info.setCommodityName(item.getCommodityName());
            info.setCommodityCount(item.getNum());
            info.setWholesalerHead(wholesalerHead);
            info.setMotorcadeHead(motorcadeHead);
            info.setStoreHeadInput(storeHeadInput);


            return info;
        }).map(item -> {
            storageDetailInfoRepo.insert(item);

            int updated = inventoryInfoRepo.increaseCommodityCountByUpdate(item.getStoreIdInput(), item.getCommodityId(), item.getCommodityCount());
            // 更新数为0时，表示记录不存在，插入新的
            if (updated == 0) {
                inventoryInfoRepo.increaseCommodityCountByInsert(item.getStoreIdInput(), item.getCommodityId(), item.getCommodityCount());
            }

            return item;
        }).collect(toList());

        return ResponseEntity.ok().build();
    }

}
