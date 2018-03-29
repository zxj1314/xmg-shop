package com.seemygo.shop.api.goods.domain;

import java.io.Serializable;

public class ProductSkuProperty implements Serializable{

    private Long id;
    private Long productSkuId;

    private SkuProperty skuProperty;

    private String value;

    private String image;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductSkuId() {
        return productSkuId;
    }

    public void setProductSkuId(Long productSkuId) {
        this.productSkuId = productSkuId;
    }

   

    public SkuProperty getSkuProperty() {
		return skuProperty;
	}

	public void setSkuProperty(SkuProperty skuProperty) {
		this.skuProperty = skuProperty;
	}

	public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}