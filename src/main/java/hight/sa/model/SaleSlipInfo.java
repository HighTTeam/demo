package hight.sa.model;

import lombok.Data;

import java.util.Date;

/**
 * Created by gibson.luo on 2017/3/11.
 */
@Data
public class SaleSlipInfo {

    private String saleSlipId;
    private String vehicleStoreId;
    private String simCardId;
    private String driverCardId;
    private Float saleAmount;
    private Date saleDateTime;

}
