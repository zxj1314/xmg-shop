package com.seemygo.shop.api.goods.domain;

import java.io.Serializable;

public class SkuPropertyValue implements Serializable{

    private Long id;
    private SkuProperty skuProperty;

    private String value;

    private Integer sequence;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }
}