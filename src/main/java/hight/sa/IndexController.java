package hight.sa;

import hight.sa.model.*;
import hight.sa.repository.*;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by neron.liu on 09/03/2017.
 */
@Controller
public class IndexController {

    @Autowired
    private StoreHouseInfoRepo storeHouseInfoRepo;

    @Autowired
    private VehicleStoreInfoRepo vehicleStoreInfoRepo;

    @Autowired
    private CommodityInfoRepo commodityInfoRepo;

    @Autowired
    private DeliveryCartRepo deliveryCartRepo;

    @Autowired
    private DeliveryRepo deliveryRepo;

    @Autowired
    private InventoryInfoRepo inventoryInfoRepo;

    @Value("${application.message:Hello World}")
    private String message = "Hello World";

    @GetMapping("/index")
    public String index(HttpSession session) {
        if ("true".equals(session.getAttribute("isLoggedIn"))) {
            return "index";
        }

        return "redirect:/";
    }

    private String uniqueId() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String createTime = sdf.format(new Date());

        String createTimeMs = String.valueOf(System.currentTimeMillis());
        return createTime + createTimeMs.substring(createTimeMs.length() - 5, createTime.length() - 1);
    }

    @GetMapping("/godown_entry")
    public String getGodownEntry(Map<String, Object> model) {
        String godownEntryId = uniqueId();

        model.put("distributionId", godownEntryId);

        // 仓库
        List<StoreHouseInfo> storeHouseInfoList = storeHouseInfoRepo.getSelectedList();
        model.put("storeHouses", storeHouseInfoList);

        // 商品
        List<CommodityInfo> commodityInfoList = commodityInfoRepo.getSelectedList();
        model.put("goodsList", commodityInfoList);

        return "godown_entry";
    }

    @GetMapping("/delivery")
    public String getDelivery(Map<String, Object> model) {
        // 配送单号
        String distributionId = uniqueId();
        model.put("distributionId", distributionId);

        // 仓库
        List<StoreHouseInfo> storeHouseInfoList = storeHouseInfoRepo.getSelectedList();
        model.put("storeHouses", storeHouseInfoList);

        // 车库
        List<VehicleStoreInfo> vehicleStoreInfoList = vehicleStoreInfoRepo.getSelectedList();
        model.put("vehicleStores", vehicleStoreInfoList);

        // 商品
        List<CommodityInfo> commodityInfoList = commodityInfoRepo.getSelectedList();
        model.put("goodsList", commodityInfoList);

        return "delivery";
    }

    @GetMapping("/delivery_details")
    public String getDeliveryDetail(Map<String, Object> model, @RequestParam(value = "distributionId", required = false) String distributionId) {

        if (StringUtils.isNotBlank(distributionId)) {
            List<DeliveryCart> cartList = deliveryCartRepo.getCartList(distributionId);
            model.put("cartList", cartList);
        }

        return "delivery_details";
    }

    @PostMapping("/delivery_confirm")
    public String confirmDelivery(Map<String, Object> model,
                                  @RequestParam(value = "distributionId") String distributionId,
                                  @RequestParam(value = "vehicleStoreId") String vehicleStoreId,
                                  @RequestParam(value = "stockInName") String stockInName,
                                  @RequestParam(value = "stockOutName") String stockOutName) {
        List<DeliveryCart> cart = Optional.ofNullable(deliveryCartRepo.getCartList(distributionId)).orElse(Collections.emptyList());

        List<Delivery> deliveries = cart.stream().map(item -> {
            Delivery delivery = new Delivery();
            delivery.setDistributionId(distributionId);
            delivery.setVehicleStoreId(vehicleStoreId);
            delivery.setStoreHouseId(item.getLogicStoreId());
            delivery.setCommodityId(item.getCommodityId());
            delivery.setCommodityCount(item.getNum());
            delivery.setStockInName(stockInName);
            delivery.setStockOutName(stockOutName);

            return delivery;
        }).map(item -> {
            deliveryRepo.create(item);

            return item;
        }).collect(Collectors.toList());

        model.put("distributionId", distributionId);
        model.put("deliveries", deliveries);

        return "delivery_result";
    }

}
