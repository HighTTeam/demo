package hight.sa.model;

import lombok.Data;

import java.util.Date;

/**
 * Created by gibson.luo on 2017/3/11.
 */
@Data
public class VehicleStoreInfo {

    private String id;
    private String name;
    private String vehicleId;
    private String vendingMachineId;
    private String terminalId;
    private String terminalCfgUI;
    private String simCardId;
    private String vehicleStoreContacts;
    private String vehicleStoreNumber;
    private String vehicleStoreCardId;
    private String driverCardId;
    private Date vehicleStoreCrtTime;
    private Date driverStatusUpdateTime;

}
