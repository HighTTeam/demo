package hight.sa.model;

import lombok.Data;

import java.util.Date;

/**
 * Created by gibson.luo on 2017/3/11.
 */
@Data
public class DistributionDetailInfo {

    private String distributionId;
    private String logicStoreIdOutput;
    private String logicStoreNameOutput;
    private String logicStoreIdInput;
    private String logicStoreNameInput;
    private String commodityId;
    private String commodityName;
    private Integer commodityCount;
    private String logicStoreHeadOutput;
    private String logicStoreHeadInput;
    private Date crtTime;

}
