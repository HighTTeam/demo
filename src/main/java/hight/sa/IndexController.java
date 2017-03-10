package hight.sa;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.UUID;

/**
 * Created by neron.liu on 09/03/2017.
 */
@Controller
public class IndexController {

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
    public String goodsDelivery(Map<String, Object> model){
        String distributionId = UUID.randomUUID().toString();

        model.put("distributionId", distributionId);

        model.put("storeHouses", Lists.newArrayList("公司总仓库", "遵义总仓库", "贵阳总仓库"));
        model.put("vehicleStores", Lists.newArrayList("车辆编号000000001", "车辆编号000000002", "车辆编号000000003"));
        model.put("goodsList", Lists.newArrayList("景田矿泉水", "百事可乐", "可口可乐", "口香糖"));


        return "goods_delivery";
    }

    @GetMapping("/goods_delivery_details")
    public String goodsDeliveryDetail(Map<String, Object> model){
        return "goods_delivery_details";
    }


}
