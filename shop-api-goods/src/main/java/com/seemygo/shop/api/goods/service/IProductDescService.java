package com.seemygo.shop.api.goods.service;


import com.seemygo.shop.api.goods.domain.ProductDesc;

import java.util.List;

public interface IProductDescService {

	int deleteByPrimaryKey(Long id);

    int insert(ProductDesc record);

    ProductDesc selectByPrimaryKey(Long id);

    List<ProductDesc> selectAll();

    int updateByPrimaryKey(ProductDesc record);

	ProductDesc getDescByProductId(Long productId);
}
