package com.seemygo.server.goods.mapper;


import com.seemygo.shop.api.goods.domain.ProductDesc;

import java.util.List;

public interface ProductDescMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ProductDesc record);

    ProductDesc selectByPrimaryKey(Long id);

    List<ProductDesc> selectAll();

    int updateByPrimaryKey(ProductDesc record);

	ProductDesc getDescByProductId(Long id);
}