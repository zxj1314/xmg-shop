package com.seemygo.server.goods.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.seemygo.server.goods.mapper.SkuPropertyMapper;
import com.seemygo.server.goods.mapper.SkuPropertyValueMapper;
import com.seemygo.shop.api.goods.domain.SkuProperty;
import com.seemygo.shop.api.goods.domain.SkuPropertyValue;
import com.seemygo.shop.api.goods.service.ISkuPropertyService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class SkuPropertyServiceImpl implements ISkuPropertyService {

	@Autowired
	SkuPropertyMapper skuPropertyDao;
	@Autowired
	SkuPropertyValueMapper skuPropertyValueDao;
	
	@Override
	public int deleteByPrimaryKey(Long propertyId) {
		// TODO Auto-generated method stub
		skuPropertyValueDao.deleteByPropertyId(propertyId);
		return skuPropertyDao.deleteByPrimaryKey(propertyId);
	}

	@Override
	public int insert(SkuProperty skuProperty) {
		// TODO Auto-generated method stub
		return skuPropertyDao.insert(skuProperty);
	}

	@Override
	public SkuProperty selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return skuPropertyDao.selectByPrimaryKey(id);
	}

	@Override
	public List<SkuProperty> selectAll() {
		// TODO Auto-generated method stub
		return skuPropertyDao.selectAll();
	}

	@Override
	public int updateByPrimaryKey(SkuProperty record) {
		// TODO Auto-generated method stub
		return skuPropertyDao.updateByPrimaryKey(record);
	}

	@Override
	public List<SkuProperty> getSkuProperty(Long catalogId) {
		// TODO Auto-generated method stub
		return skuPropertyDao.getSkuProperty(catalogId);
	}

	@Override
	public List<SkuPropertyValue> getSkuPropertyValue(
			Long skuPropertyId) {
		// TODO Auto-generated method stub
		return skuPropertyValueDao.getSkuPropertyValue(skuPropertyId);
	}

	@Override
	public void insertPropertyValue(SkuPropertyValue skuPropertyValue) {
		// TODO Auto-generated method stub
		skuPropertyValueDao.insert(skuPropertyValue);
	}



}
