package com.seemygo.shop.api.goods.service;


import com.seemygo.shop.api.goods.domain.ProductImage;

import java.util.List;


public interface IProductImageService {

	int deleteByPrimaryKey(Long id);

    int insert(ProductImage record);

    ProductImage selectByPrimaryKey(Long id);

    List<ProductImage> selectAll();

    int updateByPrimaryKey(ProductImage record);

	List<ProductImage> getImageByProductId(Long id);
}
