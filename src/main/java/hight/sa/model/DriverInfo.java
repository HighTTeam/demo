package hight.sa.model;

import lombok.Data;

import java.util.Date;

/**
 * Created by gibson.luo on 2017/3/11.
 */
@Data
public class DriverInfo {

    private String cardId;
    private String name;
    private String driverNo;
    private String driverLicense;
    private String sex;
    private String telNumber;
    private String address;
    private String emergencyContent;
    private String emergencyTelNumber;
    private String weiXinCount;
    private String zhiFuBaoCount;
    private String yiZhiFuCount;
    private String bankCount;
    private String defaultCount;
    private Integer areaCodeId;
    private String companyName;
    private String serviceStatus;
    private Date crtTime;

}
