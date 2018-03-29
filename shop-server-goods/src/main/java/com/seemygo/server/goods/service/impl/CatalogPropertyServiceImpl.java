package com.seemygo.server.goods.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.seemygo.server.goods.mapper.CatalogPropertyMapper;
import com.seemygo.server.goods.mapper.CatalogPropertyValueMapper;
import com.seemygo.shop.api.goods.domain.CatalogProperty;
import com.seemygo.shop.api.goods.domain.CatalogPropertyValue;
import com.seemygo.shop.api.goods.service.ICatalogPropertyService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class CatalogPropertyServiceImpl implements ICatalogPropertyService {

	@Autowired
	CatalogPropertyMapper catalogPropertyDao;
	@Autowired
    CatalogPropertyValueMapper catalogPropertyValueDao;
	
	@Override
	public int deleteByPrimaryKey(Long propertyId) {
		// TODO Auto-generated method stub
		catalogPropertyValueDao.deleteByPropertyId(propertyId);
		return catalogPropertyDao.deleteByPrimaryKey(propertyId);
	}

	@Override
	public int insert(CatalogProperty catalogProperty) {
		// TODO Auto-generated method stub
		return catalogPropertyDao.insert(catalogProperty);
	}

	@Override
	public CatalogProperty selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return catalogPropertyDao.selectByPrimaryKey(id);
	}

	@Override
	public List<CatalogProperty> selectAll() {
		// TODO Auto-generated method stub
		return catalogPropertyDao.selectAll();
	}

	@Override
	public int updateByPrimaryKey(CatalogProperty record) {
		// TODO Auto-generated method stub
		return catalogPropertyDao.updateByPrimaryKey(record);
	}

	@Override
	public List<CatalogProperty> getCatalogProperty(Long catalogId) {
		// TODO Auto-generated method stub
		return catalogPropertyDao.getCatalogProperty(catalogId);
	}

	@Override
	public List<CatalogPropertyValue> getCatalogPropertyValue(
			Long catalogPropertyId) {
		// TODO Auto-generated method stub

        return catalogPropertyValueDao.getCatalogPropertyValue(catalogPropertyId);
	}

	@Override
	public void insertPropertyValue(CatalogPropertyValue catalogPropertyValue) {
		// TODO Auto-generated method stub
		catalogPropertyValueDao.insert(catalogPropertyValue);
	}

	@Override
	public void deleteCatalogPropertyValue(Long catalogPropertyId) {
		// TODO Auto-generated method stub
		catalogPropertyValueDao.deleteByPrimaryKey(catalogPropertyId);
	}



}
