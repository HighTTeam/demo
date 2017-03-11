package hight.sa.viewmodel;

import lombok.Data;

/**
 * Created by gibson.luo on 2017/3/11.
 */
@Data
public class ViewDeliveryDetailGoods {

    public ViewDeliveryDetailGoods() {
    }

    public ViewDeliveryDetailGoods(String id, String name, Integer num) {
        this.id = id;
        this.name = name;
        this.num = num;
    }

    private String id;
    private String name;
    private Integer num;

}
