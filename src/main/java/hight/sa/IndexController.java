package hight.sa;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
    public String index(Map<String, Object> model) {
        return "index";
    }

    @GetMapping("/goods_delivery")
    public String goodsDelivery(Map<String, Object> model){
        String distributionId = UUID.randomUUID().toString();

        model.put("distributionId", distributionId);

        model.put("storeHouses", Lists.newArrayList("1", "2", "3"));
        model.put("vehicleStores", Lists.newArrayList("3", "2", "1"));
        model.put("goodsList", Lists.newArrayList("3", "2", "1"));


        return "goods_delivery";
    }


}
