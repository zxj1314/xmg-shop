package com.seemygo.server.goods.mapper;


import com.seemygo.shop.api.goods.domain.SkuPropertyValue;

import java.util.List;

public interface SkuPropertyValueMapper {
    int deleteByPrimaryKey(Long id);

    int insert(SkuPropertyValue record);

    SkuPropertyValue selectByPrimaryKey(Long id);

    List<SkuPropertyValue> selectAll();

    int updateByPrimaryKey(SkuPropertyValue record);
    
    void deleteByPropertyId(Long propertyId);

	List<SkuPropertyValue> getSkuPropertyValue(Long skuPropertyId);

}