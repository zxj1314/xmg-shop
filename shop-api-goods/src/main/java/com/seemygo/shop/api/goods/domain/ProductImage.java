package com.seemygo.shop.api.goods.domain;

import java.io.Serializable;

public class ProductImage implements Serializable{
    private Long id;

    private Long productId;

    private String imagePath;

    private Integer sequence;

    private Long mods = 1L;
    
    private Byte cover;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Long getMods() {
        return mods;
    }

    public void setMods(Long mods) {
        this.mods = mods;
    }

	public Byte getCover() {
		return cover;
	}

	public void setCover(Byte cover) {
		this.cover = cover;
	}
    
}