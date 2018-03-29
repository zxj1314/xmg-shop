package com.seemygo.server.goods.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.seemygo.server.goods.mapper.ProductImageMapper;
import com.seemygo.shop.api.goods.domain.ProductImage;
import com.seemygo.shop.api.goods.service.IProductImageService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ProductImageServiceImpl implements IProductImageService {

	@Autowired
	ProductImageMapper productImageDao;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return productImageDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(ProductImage record) {
		// TODO Auto-generated method stub
		return productImageDao.insert(record);
	}

	@Override
	public ProductImage selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return productImageDao.selectByPrimaryKey(id);
	}

	@Override
	public List<ProductImage> selectAll() {
		// TODO Auto-generated method stub
		return productImageDao.selectAll();
	}

	@Override
	public int updateByPrimaryKey(ProductImage record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<ProductImage> getImageByProductId(Long productId) {
		// TODO Auto-generated method stub
		return productImageDao.getImageByProductId(productId);
	}

}
