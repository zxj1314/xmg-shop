package com.seemygo.server.goods.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.seemygo.server.goods.mapper.ProductDescMapper;
import com.seemygo.shop.api.goods.domain.ProductDesc;
import com.seemygo.shop.api.goods.service.IProductDescService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ProductDescServiceImpl implements IProductDescService {

	@Autowired
	ProductDescMapper productDescDao;
	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(ProductDesc record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ProductDesc selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return productDescDao.selectByPrimaryKey(id);
	}

	@Override
	public List<ProductDesc> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateByPrimaryKey(ProductDesc record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ProductDesc getDescByProductId(Long id) {
		// TODO Auto-generated method stub
		return productDescDao.getDescByProductId(id);
	}

}
