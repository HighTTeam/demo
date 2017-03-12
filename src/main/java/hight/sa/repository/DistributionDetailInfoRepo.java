package hight.sa.repository;

import hight.sa.model.DistributionDetailInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by gibson.luo on 2017/3/12.
 */
@Mapper
public interface DistributionDetailInfoRepo {

    @Insert("insert into DistributionDetailInfo(" +
            "DistributionID, LogicStoreIDOutput, LogicStoreNameOutput, LogicStoreIDInput, LogicStoreNameInput, CommodityID, CommodityName, CommodityCount, LogicStoreHeadOutput, LogicStoreHeadInput)" +
            "values(#{distributionId}, #{logicStoreIdOutput}, #{logicStoreNameOutput}, #{logicStoreIdInput}, #{logicStoreNameInput}, #{commodityId}, #{commodityName}, #{commodityCount}, #{logicStoreHeadOutput}, #{logicStoreHeadInput})")
    int create(DistributionDetailInfo distributionDetailInfo);


}
