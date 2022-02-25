package com.wk.service;

import com.github.pagehelper.PageInfo;
import com.wk.entity.ProductInfo;
import com.wk.entity.vo.ProductInfoVo;

import java.util.List;

/**
 * @className: com.wk.service.ProductInfoService
 * @description: TODO
 * @author: 酷盖i
 * @create: 2022-02-22 13:15
 */
public interface ProductInfoService {

    //显示全部商品（不分页）
    List<ProductInfo> getAll();

    //分页功能实现
    PageInfo splitPage(int pageNum,int pageSize);

    int save(ProductInfo info);

    //按主键id查询商品
    ProductInfo getById(int pid);

    //更新商品
    int update(ProductInfo info);

    //单个商品删除
    int delete(int pid);

    //批量删除
    int deleteBatch(String []pids);

    //多条件查询
    List<ProductInfo> selectCondition(ProductInfoVo vo);

    //多条件查询分页
    public PageInfo splitPageVo(ProductInfoVo vo,int pageSize);
}
