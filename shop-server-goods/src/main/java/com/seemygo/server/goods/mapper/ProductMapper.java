package com.seemygo.server.goods.mapper;

import com.seemygo.shop.api.goods.domain.Product;
import com.seemygo.shop.api.goods.query.ProductQueryObject;

import java.util.List;

public interface ProductMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Product record);

    Product selectByPrimaryKey(Long id);

    List<Product> selectAll();

    int updateByPrimaryKey(Product record);

    int queryForCount(ProductQueryObject qo);

    List<Product> query(ProductQueryObject qo);
}