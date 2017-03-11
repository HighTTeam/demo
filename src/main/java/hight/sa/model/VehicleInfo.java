package hight.sa.model;

import lombok.Data;

import java.util.Date;

/**
 * Created by gibson.luo on 2017/3/11.
 */
@Data
public class VehicleInfo {

    private String id;
    private String vehicleNo;
    private String type;
    private String routeInfo;
    private Integer seats;
    private Integer areaCodeId;
    private String company;
    private Date crtTime;

}
