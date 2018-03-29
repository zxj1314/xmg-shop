package com.seemygo.shop.api.goods.service;


import com.seemygo.shop.api.goods.domain.ProductSku;
import com.seemygo.shop.api.goods.domain.SkuGenerateFormVo;
import com.seemygo.shop.api.goods.vo.ProductVo;

import java.util.List;
import java.util.Map;


public interface IProductSkuService {

	int deleteByPrimaryKey(Long id);

    int insert(ProductSku record);

    ProductSku selectByPrimaryKey(Long id);

    List<ProductSku> selectAll();

    int updateByPrimaryKey(ProductSku record);

	List<ProductSku> getSkuByProductId(Long productId);
	
	/**
	 * 生成sku
	 * @param vo
	 * @return
	 */
	List<Map<String, Object>> generateSku(SkuGenerateFormVo vo);

	/**
	 * 保存sku
	 * @param vo
	 */
	void save(ProductVo vo);
}
