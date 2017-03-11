package hight.sa.model;

import lombok.Data;

import java.util.Date;

/**
 * Created by gibson.luo on 2017/3/11.
 */
@Data
public class CommodityInfo {

    private String id;
    private String name;
    private String model;
    private String batchNo;
    private String manufacturer;
    private String agent;
    private Float price;
    private String unit;
    private Date onSaleTime;
    private Date offSaleTime;

}
