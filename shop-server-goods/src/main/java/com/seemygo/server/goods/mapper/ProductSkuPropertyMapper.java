package com.seemygo.server.goods.mapper;


import com.seemygo.shop.api.goods.domain.ProductSkuProperty;

import java.util.List;

public interface ProductSkuPropertyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProductSkuProperty record);

    ProductSkuProperty selectByPrimaryKey(Long id);

    List<ProductSkuProperty> selectAll();

    int updateByPrimaryKey(ProductSkuProperty record);
}