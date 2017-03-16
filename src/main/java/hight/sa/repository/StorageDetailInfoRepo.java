package hight.sa.repository;

import hight.sa.model.StorageDetailInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by neron.liu on 16/03/2017.
 */
@Mapper
public interface StorageDetailInfoRepo {

    @Insert("insert into StorageDetailInfo(" +
            "GodownEntryID, StoreIDInput, StoreNameInput, CommodityID, CommodityName, CommodityCount, WholesalerHead, MotorcadeHead, StoreHeadInput)" +
            "values(#{godownEntryId}, #{storeIdInput}, #{storeNameInput}, #{commodityId}, #{commodityName}, #{commodityCount}, " +
            "#{wholesalerHead}, #{motorcadeHead}, #{storeHeadInput})")
    int insert(StorageDetailInfo info);

}

