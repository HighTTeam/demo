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
@Entity
@Table(name = "StoreHouseInfo")
public class StoreHouseInfo {

    @Id
    @Column(name = "StoreHouseID")
    private String id;

    @Column(name ="StoreHouseName")
    private String name;

    @Column(name ="StoreHouseAddr")
    private String addr;

    @Column(name ="StoreHouseContacts")
    private String contacts;

    @Column(name ="StoreHouseTelNumber")
    private String telNumber;

    @Column(name ="StoreHouseCardID")
    private String cardId;

    @Column(name ="CrtTime")
    private Date crtTime;

}
