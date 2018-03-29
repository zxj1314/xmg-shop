package com.seemygo.shop.api.goods.vo;

import com.seemygo.shop.api.goods.domain.*;

import java.io.Serializable;
import java.util.List;

public class ProductVo  implements Serializable {

	private Product product;
	private ProductDesc productDesc;
	private List<ProductImage> productImages;
	private List<ProductCatalogPropertyValue> propertys;
	private List<ProductSku> productSkuList;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ProductDesc getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(ProductDesc productDesc) {
		this.productDesc = productDesc;
	}

	public List<ProductImage> getProductImages() {
		return productImages;
	}

	public void setProductImages(List<ProductImage> productImages) {
		this.productImages = productImages;
	}

	public List<ProductCatalogPropertyValue> getPropertys() {
		return propertys;
	}

	public void setPropertys(List<ProductCatalogPropertyValue> propertys) {
		this.propertys = propertys;
	}

	public List<ProductSku> getProductSkuList() {
		return productSkuList;
	}

	public void setProductSkuList(List<ProductSku> productSkuList) {
		this.productSkuList = productSkuList;
	}
}