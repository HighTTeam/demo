package hight.sa.repository;

import hight.sa.model.Delivery;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by neron.liu on 12/03/2017.
 */
@Mapper
public interface DeliveryRepo {

    @Insert("insert into Delivery(" +
            "DistributionID, StoreHouseID, VehicleStoreID, CommodityID, CommodityCount, StockInName, StoreOutName)" +
            "values(#{distributionId}, #{storeHouseId}, #{vehicleStoreId}, #{commodityId}, #{commodityCount}, #{stockInName}, #{stockOutName})")
    public int create(Delivery delivery);

}
