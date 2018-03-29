package com.seemygo.shop.api.goods.service;


import com.seemygo.shop.api.goods.domain.ProductCatalogPropertyValue;

import java.util.List;

public interface IProductCatalogPropertyValueService {

	List<ProductCatalogPropertyValue> getPropertyByProductId(Long productId);

	
}
