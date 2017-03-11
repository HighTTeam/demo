package hight.sa.model;

import lombok.Data;

import java.util.Date;

/**
 * Created by gibson.luo on 2017/3/11.
 */
@Data
public class InventoryInfo {

    private String logicStoreId;
    private String commodityId;
    private Integer commodityCount;
    private Date updateTime;

}
