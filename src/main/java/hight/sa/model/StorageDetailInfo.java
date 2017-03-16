package hight.sa.model;

import lombok.Data;

import java.util.Date;

/**
 * Created by neron.liu on 16/03/2017.
 */
@Data
public class StorageDetailInfo {

    private String godownEntryId;
    private String storeIdInput;
    private String storeNameInput;
    private String commodityId;
    private String commodityName;
    private int commodityCount;
    private String wholesalerHead;
    private String motorcadeHead;
    private String storeHeadInput;
    private Date crtTime;

}
