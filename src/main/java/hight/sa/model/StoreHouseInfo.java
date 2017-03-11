package hight.sa.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by neron.liu on 10/03/2017.
 */
@Data
public class StoreHouseInfo {

    private String id;
    private String name;
    private String address;
    private String contacts;
    private String telNumber;
    private String cardId;
    private Date crtTime;

}
