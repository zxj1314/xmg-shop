package com.seemygo.shop.api.goods.domain;


import java.io.Serializable;

public class CatalogProperty implements Serializable{
    private Long id;

    private Long catalogId;

    private String name;

    private Integer sequence;

    private Byte type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(Long catalogId) {
        this.catalogId = catalogId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }
    
    public String getPropertyType(){
    	String propertyType = "输入框";
    	switch (this.type) {
		case 0:
			propertyType = "输入框";
			break;
		case 1:
			propertyType = "复选框";
			break;
		case 2:
			propertyType = "下拉列表";
			break;

		default:
			propertyType = "输入框";
			break;
		}
    	return propertyType;
    }
}






