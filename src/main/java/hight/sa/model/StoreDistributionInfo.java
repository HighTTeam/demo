package hight.sa.model;

import lombok.Data;

import java.util.Date;

/**
 * Created by gibson.luo on 2017/3/11.
 */
@Data
public class StoreDistributionInfo {

    private String id;
    private String name;
    private String address;
    private String contacts;
    private String telNumber;
    private String cardId;
    private Date crtTime;

}
