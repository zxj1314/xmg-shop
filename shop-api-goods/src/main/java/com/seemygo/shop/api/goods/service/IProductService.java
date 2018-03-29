package com.seemygo.shop.api.goods.service;


import com.seemygo.shop.api.goods.domain.Product;
import com.seemygo.shop.api.goods.query.PageResult;
import com.seemygo.shop.api.goods.query.ProductQueryObject;
import com.seemygo.shop.api.goods.vo.ProductVo;

import java.util.List;


public interface IProductService {

	int deleteByPrimaryKey(Long id);

    int insert(Product record);

    Product selectByPrimaryKey(Long id);

    List<Product> selectAll();

    int updateByPrimaryKey(Product record);
    
    int queryCount(ProductQueryObject qo);
    
    PageResult query(ProductQueryObject qo);

    Product save(ProductVo vo);
}
