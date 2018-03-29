package com.seemygo.server.goods.mapper;


import com.seemygo.shop.api.goods.domain.ProductCatalogPropertyValue;

import java.util.List;

public interface ProductCatalogPropertyValueMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProductCatalogPropertyValue record);

    ProductCatalogPropertyValue selectByPrimaryKey(Long id);

    List<ProductCatalogPropertyValue> selectAll();

    int updateByPrimaryKey(ProductCatalogPropertyValue record);

	List<ProductCatalogPropertyValue> getPropertyByProductId(Long productId);
}