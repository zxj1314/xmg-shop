package com.seemygo.server.goods.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.seemygo.server.goods.mapper.CatalogMapper;
import com.seemygo.shop.api.goods.domain.Catalog;
import com.seemygo.shop.api.goods.service.ICatalogService;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

@Service
public class CatalogServiceImpl implements ICatalogService {

	@Autowired
	CatalogMapper catalogDao;
	
	@Override
	public List<Catalog> getChildenCatalogById(Long parentId) {
		// TODO Auto-generated method stub

		return catalogDao.getChildenCatalogById(parentId);
	}

	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return catalogDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Catalog catalog) {
		// TODO Auto-generated method stub
		catalog.setCreateDate(new Date());
		catalog.setIsParent(Byte.valueOf("0"));
		catalog.setLastModifiedDate(new Date());
		catalog.setVersion(0);
		catalog.setSequence(1);
		Catalog parentCatalog = catalogDao.selectByPrimaryKey(catalog.getParentCatalogId());
		parentCatalog.setIsParent(Byte.valueOf("1"));
		catalogDao.updateByPrimaryKey(parentCatalog);
		return catalogDao.insert(catalog);
	}

	@Override
	public Catalog selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return catalogDao.selectByPrimaryKey(id);
	}

	@Override
	public List<Catalog> selectAll() {
		// TODO Auto-generated method stub
		return catalogDao.selectAll();
	}

	@Override
	public int updateByPrimaryKey(Catalog record) {
		// TODO Auto-generated method stub
		return catalogDao.updateByPrimaryKey(record);
	}

}
