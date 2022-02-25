package com.wk.test;

import com.wk.dao.ProductInfoMapper;
import com.wk.entity.ProductInfo;
import com.wk.entity.vo.ProductInfoVo;
import com.wk.utils.MD5Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @className: com.wk.test.MyTest
 * @description: TODO
 * @author: 酷盖i
 * @create: 2022-02-20 18:30
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MyTest {
    @Autowired
    ProductInfoMapper mapper;
    @Test
    public void testMD5(){
        String mi= MD5Util.getMD5("000000");
        System.out.println(mi);
    }

    @Test
    public void testSelectCondition(){
        ProductInfoVo vo=new ProductInfoVo();
        //vo.setpName("4");
        //vo.setTypeId(3);
        vo.setlPrice(3000);
        vo.sethPrice(4000);
        List<ProductInfo> listInfo=mapper.selectCondition(vo);
        listInfo.forEach(productInfo -> System.out.println(productInfo));

    }
}
