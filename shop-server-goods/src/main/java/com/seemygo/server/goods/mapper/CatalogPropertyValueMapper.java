package com.seemygo.server.goods.mapper;


import com.seemygo.shop.api.goods.domain.CatalogPropertyValue;

import java.util.List;

public interface CatalogPropertyValueMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CatalogPropertyValue record);

    CatalogPropertyValue selectByPrimaryKey(Long id);

    List<CatalogPropertyValue> selectAll();

    int updateByPrimaryKey(CatalogPropertyValue record);

	List<CatalogPropertyValue> getCatalogPropertyValue(Long catalogPropertyId);

	void deleteByPropertyId(Long propertyId);
}