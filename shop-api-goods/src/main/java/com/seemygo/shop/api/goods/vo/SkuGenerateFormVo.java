package com.seemygo.shop.api.goods.vo;



import com.seemygo.shop.api.goods.domain.SkuProperty;
import com.seemygo.shop.api.goods.domain.SkuPropertyValue;

import java.io.Serializable;
import java.util.List;


public class SkuGenerateFormVo  implements Serializable{
	
	private Long productId;
    private List<SkuProperty> skuPropertieList;
    private List<SkuPropertyValue> skuPropertyValueList;
	public List<SkuProperty> getSkuPropertieList() {
		return skuPropertieList;
	}
	public void setSkuPropertieList(List<SkuProperty> skuPropertieList) {
		this.skuPropertieList = skuPropertieList;
	}
	public List<SkuPropertyValue> getSkuPropertyValueList() {
		return skuPropertyValueList;
	}
	public void setSkuPropertyValueList(List<SkuPropertyValue> skuPropertyValueList) {
		this.skuPropertyValueList = skuPropertyValueList;
	}
	public Long getProductId() {
		return productId;
	}
	public void setProductId(Long productId) {
		this.productId = productId;
	}
	
	
	
    
}
