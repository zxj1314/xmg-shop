package com.seemygo.server.goods.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.seemygo.server.goods.mapper.ProductCatalogPropertyValueMapper;
import com.seemygo.shop.api.goods.domain.ProductCatalogPropertyValue;
import com.seemygo.shop.api.goods.service.IProductCatalogPropertyValueService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ProductCatalogPropertyValueServiceImpl implements IProductCatalogPropertyValueService {

	@Autowired
	ProductCatalogPropertyValueMapper productCatalogPropertyValueDao;
	@Override
	public List<ProductCatalogPropertyValue> getPropertyByProductId(
			Long productId) {
		// TODO Auto-generated method stub
		return productCatalogPropertyValueDao.getPropertyByProductId(productId);
	}

}
