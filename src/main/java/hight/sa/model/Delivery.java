package hight.sa.model;

import lombok.Data;

import java.util.Date;

/**
 * Created by neron.liu on 12/03/2017.
 */
@Data
public class Delivery {

    private Integer id;

    private String distributionId;

    private String storeHouseId;

    private String vehicleStoreId;

    private String commodityId;

    private Integer commodityCount;

    /**
     * 进货仓库负责人
     */
    private String stockInName;

    /**
     * 出货仓库负责人
     */
    private String stockOutName;

    private Date createTime;

}
