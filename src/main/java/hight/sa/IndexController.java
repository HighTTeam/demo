package hight.sa;

import hight.sa.model.CommodityInfo;
import hight.sa.model.StoreHouseInfo;
import hight.sa.model.VehicleStoreInfo;
import hight.sa.repository.CommodityInfoRepo;
import hight.sa.repository.StoreHouseInfoRepo;
import hight.sa.repository.VehicleStoreInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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

    @Value("${application.message:Hello World}")
    private String message = "Hello World";

    @GetMapping("/index")
    public String index(HttpSession session) {
        if ("true".equals(session.getAttribute("isLoggedIn"))) {
            return "index";
        }

        return "redirect:/";
    }

    @GetMapping("/goods_delivery")
    public String goodsDelivery(Map<String, Object> model) {
        // 配送单号
        String distributionId = UUID.randomUUID().toString();
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

        return "goods_delivery";
    }

    @GetMapping("/goods_delivery_details")
    public String goodsDeliveryDetail(Map<String, Object> model) {
        return "goods_delivery_details";
    }


}
