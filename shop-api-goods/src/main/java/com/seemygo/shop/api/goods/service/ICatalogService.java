package com.seemygo.shop.api.goods.service;


import com.seemygo.shop.api.goods.domain.Catalog;

import java.util.List;


public interface ICatalogService {
	int deleteByPrimaryKey(Long id);

    int insert(Catalog catalog);

    Catalog selectByPrimaryKey(Long id);

    List<Catalog> selectAll();

    int updateByPrimaryKey(Catalog record);

	List<Catalog> getChildenCatalogById(Long parentId);


}
