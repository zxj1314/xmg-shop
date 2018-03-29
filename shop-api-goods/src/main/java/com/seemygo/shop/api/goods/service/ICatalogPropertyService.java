package com.seemygo.shop.api.goods.service;


import com.seemygo.shop.api.goods.domain.CatalogProperty;
import com.seemygo.shop.api.goods.domain.CatalogPropertyValue;

import java.util.List;


public interface ICatalogPropertyService {

	int deleteByPrimaryKey(Long id);

    int insert(CatalogProperty record);

    CatalogProperty selectByPrimaryKey(Long id);

    List<CatalogProperty> selectAll();

    int updateByPrimaryKey(CatalogProperty record);

	List<CatalogProperty> getCatalogProperty(Long catalogId);


	List<CatalogPropertyValue> getCatalogPropertyValue(Long catalogPropertyId);

	void insertPropertyValue(CatalogPropertyValue catalogPropertyValue);

	void deleteCatalogPropertyValue(Long catalogPropertyId);


}





