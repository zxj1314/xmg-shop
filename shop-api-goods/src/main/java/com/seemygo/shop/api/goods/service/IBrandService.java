package com.seemygo.shop.api.goods.service;


import com.seemygo.shop.api.goods.domain.Brand;
import com.seemygo.shop.api.goods.query.BrandQueryObject;
import com.seemygo.shop.api.goods.query.PageResult;

import java.util.List;


public interface IBrandService {

    int deleteByPrimaryKey(Long id);

    int insert(Brand record);

    Brand selectByPrimaryKey(Long id);

    List<Brand> selectAll();

    int updateByPrimaryKey(Brand record);

    PageResult query(BrandQueryObject qo);
}
