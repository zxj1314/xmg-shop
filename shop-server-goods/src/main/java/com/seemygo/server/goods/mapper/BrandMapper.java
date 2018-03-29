package com.seemygo.server.goods.mapper;

import com.seemygo.shop.api.goods.domain.Brand;
import com.seemygo.shop.api.goods.query.BrandQueryObject;

import java.util.List;

public interface BrandMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Brand record);

    Brand selectByPrimaryKey(Long id);

    List<Brand> selectAll();

    int updateByPrimaryKey(Brand record);

    int queryForCount(BrandQueryObject qo);
    List<Brand> queryForList(BrandQueryObject qo);
}