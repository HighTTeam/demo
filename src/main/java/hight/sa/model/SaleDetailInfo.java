package hight.sa.model;

import lombok.Data;

import java.util.Date;

/**
 * Created by gibson.luo on 2017/3/11.
 */
@Data
public class SaleDetailInfo {

    private String saleSlipId;
    private String commodityId;
    private String commodityName;
    private Float commodityPrice;
    private Integer commodityCount;
    private Integer commodityDiscount;
    private Date saleDataTime;

}
