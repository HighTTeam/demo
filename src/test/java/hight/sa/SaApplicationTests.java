package hight.sa;

import hight.sa.model.CommodityInfo;
import hight.sa.repository.CommodityInfoRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SaApplicationTests {

    @Autowired
    private CommodityInfoRepo commodityInfoRepo;

    @Test
    public void contextLoads() {
    }

    @Test
    public void commodityInfoFindById() throws Exception {
        CommodityInfo item = commodityInfoRepo.findById("0012345678");
        System.out.println("====" + item);
    }


}
