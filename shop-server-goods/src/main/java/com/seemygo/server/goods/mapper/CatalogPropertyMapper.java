package com.seemygo.server.goods.mapper;


import com.seemygo.shop.api.goods.domain.CatalogProperty;

import java.util.List;

public interface CatalogPropertyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CatalogProperty record);

    CatalogProperty selectByPrimaryKey(Long id);

    List<CatalogProperty> selectAll();

    int updateByPrimaryKey(CatalogProperty record);

	List<CatalogProperty> getCatalogProperty(Long catalogId);
}