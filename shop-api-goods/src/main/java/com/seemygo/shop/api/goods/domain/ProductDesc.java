package com.seemygo.shop.api.goods.domain;

import java.io.Serializable;

public class ProductDesc implements Serializable{
    private Long id;
    private Long productId;

    private String details;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}