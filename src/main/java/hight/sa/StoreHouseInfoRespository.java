package hight.sa;

import hight.sa.model.StoreHouseInfo;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by neron.liu on 10/03/2017.
 */
@Repository
public interface StoreHouseInfoRespository extends PagingAndSortingRepository<StoreHouseInfo, String> {

}
