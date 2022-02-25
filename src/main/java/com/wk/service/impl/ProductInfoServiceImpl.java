package com.wk.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wk.dao.ProductInfoMapper;
import com.wk.entity.ProductInfo;
import com.wk.entity.ProductInfoExample;
import com.wk.entity.vo.ProductInfoVo;
import com.wk.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @className: com.wk.service.impl.ProductInfoServiceImpl
 * @description: TODO
 * @author: 酷盖i
 * @create: 2022-02-22 13:16
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    //!!业务逻辑层一定有数据访问层的对象
    @Autowired
    ProductInfoMapper productInfoMapper;
    @Override
    public List<ProductInfo> getAll() {

        return productInfoMapper.selectByExample(new ProductInfoExample());
    }

    //select * from product_info limit 起始记录数=（（当前页-1）*每页的条数），每页取几条
    //select * from product_info limit 10,5 第3页取5条
    @Override
    public PageInfo splitPage(int pageNum, int pageSize) {

        //分页插件使用pageHelper工具类实现分页配置
        PageHelper.startPage(pageNum,pageSize);

        //进行PageInfo的数据封装
        //进行有条件的查询操作，必须要创建ProductInfoExample对象
        ProductInfoExample example=new ProductInfoExample();
        //设置排序，按主键降序排序。 select * form product_info order by p_id desc
        example.setOrderByClause("p_id desc");

        //设置完排序后，取集合！  ！！一定要设置PageHelper.startPage(pageNum,pageSize);
        List<ProductInfo> productInfoList=productInfoMapper.selectByExample(example);

        //将查到的集合封装到PageHelper对象中
        PageInfo<ProductInfo> pageInfo=new PageInfo<>(productInfoList);


        return pageInfo;
    }

    @Override
    public int save(ProductInfo info) {
        return productInfoMapper.insert(info);
    }

    @Override
    public ProductInfo getById(int pid) {
        return productInfoMapper.selectByPrimaryKey(pid);
    }

    @Override
    public int update(ProductInfo info) {
        return productInfoMapper.updateByPrimaryKey(info);
    }

    @Override
    public int delete(int pid) {
        return productInfoMapper.deleteByPrimaryKey(pid);
    }

    @Override
    public int deleteBatch(String[] pids) {
        return productInfoMapper.deleteBatch(pids);
    }

    @Override
    public List<ProductInfo> selectCondition(ProductInfoVo vo) {
        return productInfoMapper.selectCondition(vo);
    }

    @Override
    public PageInfo splitPageVo(ProductInfoVo vo, int pageSize) {
        //取出集合之前，先要设置PageHelper.startPage()属性
        PageHelper.startPage(vo.getPage(),pageSize);
        List<ProductInfo> list=productInfoMapper.selectCondition(vo);

        return new PageInfo<>(list);
    }
}
