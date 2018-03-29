package com.seemygo.shop.api.goods.service;


import com.seemygo.shop.api.goods.domain.SkuProperty;
import com.seemygo.shop.api.goods.domain.SkuPropertyValue;

import java.util.List;


public interface ISkuPropertyService {

	int deleteByPrimaryKey(Long id);

    int insert(SkuProperty record);

    SkuProperty selectByPrimaryKey(Long id);

    List<SkuProperty> selectAll();

    int updateByPrimaryKey(SkuProperty record);

	List<SkuProperty> getSkuProperty(Long catalogId);


	List<SkuPropertyValue> getSkuPropertyValue(Long skuPropertyId);

	void insertPropertyValue(SkuPropertyValue skuPropertyValue);



}





