package com.seemygo.server.goods.mapper;


import com.seemygo.shop.api.goods.domain.SkuProperty;

import java.util.List;

public interface SkuPropertyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SkuProperty record);

    SkuProperty selectByPrimaryKey(Long id);

    List<SkuProperty> selectAll();

    int updateByPrimaryKey(SkuProperty record);

	List<SkuProperty> getSkuProperty(Long catalogId);
}