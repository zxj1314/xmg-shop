package com.seemygo.shop.api.goods.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class ProductSku implements Serializable{

    private Long id;

    private Product product;

    private String code;

    private BigDecimal price;

    private Long mods;
    
    private List<ProductSkuProperty> productSkuPropertyList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<ProductSkuProperty> getProductSkuPropertyList() {
		return productSkuPropertyList;
	}

	public void setProductSkuPropertyList(
			List<ProductSkuProperty> productSkuPropertyList) {
		this.productSkuPropertyList = productSkuPropertyList;
	}

	public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getMods() {
        return mods;
    }

    public void setMods(Long mods) {
        this.mods = mods;
    }
}