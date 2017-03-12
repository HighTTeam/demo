package hight.sa.model;

import lombok.Data;

import java.util.Date;

/**
 * Created by gibson.luo on 2017/3/12.
 */
@Data
public class DeliveryCart {

    private Long id;
    private String distributionId;
    private String logicStoreId;
    private String logicStoreName;
    private String vehicleStoreId;
    private String vehicleStoreName;
    private String commodityId;
    private String commodityName;
    private Integer num;
    private Date crtTime;

}
