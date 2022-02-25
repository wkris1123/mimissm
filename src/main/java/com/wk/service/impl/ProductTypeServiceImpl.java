package com.wk.service.impl;

import com.wk.dao.ProductTypeMapper;
import com.wk.entity.ProductType;
import com.wk.entity.ProductTypeExample;
import com.wk.service.ProductTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @className: com.wk.service.impl.ProductTypeServiceImpl
 * @description: TODO
 * @author: 酷盖i
 * @create: 2022-02-22 15:13
 *
 */
@Service("ProductTypeServiceImpl")
public class ProductTypeServiceImpl implements ProductTypeService {

    //!!业务逻辑层一定有数据访问层的对象
    @Autowired
    ProductTypeMapper productTypeMapper;

    @Override
    public List<ProductType> getAllType() {

        return productTypeMapper.selectByExample(new ProductTypeExample());
    }
}
