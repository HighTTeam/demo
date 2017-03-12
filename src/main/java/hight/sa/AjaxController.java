package hight.sa;

import hight.sa.model.DeliveryCart;
import hight.sa.model.InventoryInfo;
import hight.sa.repository.DeliveryCartRepo;
import hight.sa.repository.InventoryInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by gibson.luo on 2017/3/12.
 */
@RestController
public class AjaxController {

    @Autowired
    private DeliveryCartRepo deliveryCartRepo;

    @Autowired
    private InventoryInfoRepo inventoryInfoRepo;

    @PostMapping("/addCart")
    public ResponseEntity<?> addCart(@RequestParam(value = "distributionId") String distributionId,
                                     @RequestParam(value = "logicStoreId") String logicStoreId,
                                     @RequestParam(value = "id") String id,
                                     @RequestParam(value = "num") int num) {

        DeliveryCart deliveryCart = deliveryCartRepo.findTheSameCommodity(distributionId, id);
        if (deliveryCart == null) {
            deliveryCartRepo.addCart(distributionId, logicStoreId, id, num);
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

}
