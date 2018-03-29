package com.seemygo.client.mgrsite.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.seemygo.shop.api.goods.domain.*;
import com.seemygo.shop.api.goods.service.IProductService;
import com.seemygo.shop.api.goods.service.IProductSkuService;
import com.seemygo.shop.api.goods.service.ISkuPropertyService;
import com.seemygo.shop.api.goods.util.JSONResult;
import com.seemygo.shop.api.goods.vo.ProductVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

/**
 * 商品sku管理
 * @author luohaipeng
 *
 */
@Controller
@RequestMapping("/productSku")
public class ProductSkuController {

	@Reference
	private IProductSkuService productSkuService;

	@Reference
	private ISkuPropertyService skuPropertyService;

	@Reference
	private IProductService productService;
	
	/**
	 * 获取sku主面板(该方法废弃了)
	 * @param model
	 * @param catalogId
	 * @return
	 */
	@RequestMapping("/getSkuPropertyPanel.do")
	public String getSkuProperty(Model model, Long catalogId){
		List<SkuProperty> skuPropertyList = skuPropertyService.getSkuProperty(catalogId);
		model.addAttribute("skuPropertyList", skuPropertyList);
		return "product/sku_property_panel";
	}


	/**
	 * 跳转到生成SKU界面
	 * @param productId 需要生成SKU的商品
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{productId}",method = RequestMethod.GET)
	public String toGenerateSkuUI(@PathVariable("productId") Long productId,Model model){
		System.out.println(productId+"==================================");
		//将要生成sku的商品
		Product product = productService.selectByPrimaryKey(productId);
		model.addAttribute("product", product);

		//该商品的的sku
		List<ProductSku> productSkuList = productSkuService.getSkuByProductId(productId);

		//如果该商品之前生成过sku，那么先跳转到sku管理界面
		if(productSkuList != null && productSkuList.size() > 0){
			model.addAttribute("productSkuList", productSkuList);

			//suk列表里每条sku的sku属性,LinkedHashSet是有序并不重复的
			LinkedHashSet<String> set = new LinkedHashSet<String>();
			for (ProductSku productSku : productSkuList) {
				for (ProductSkuProperty productSkuProperty : productSku.getProductSkuPropertyList()) {

					set.add(productSkuProperty.getSkuProperty().getName());
				}
			}

			model.addAttribute("skuPropertyList", set);

			return "product/sku_manage";
		}

		//该商品的商品分类下的sku属性
		List<SkuProperty> skuPropertyList = skuPropertyService.getSkuProperty(product.getCatalog().getId());

		model.addAttribute("skuPropertyList", skuPropertyList);

		return "product/sku_generate";
	}

	/**
	 * 获取sku属性值表格
	 * @param model
	 * @param skuPropertyId
	 * @return
	 */
	@RequestMapping(value = "/skuPropertyValue/{skuPropertyId}",method = RequestMethod.GET)
	public String getSkuPropertyValueTable(Model model, @PathVariable("skuPropertyId") Long skuPropertyId){
		SkuProperty skuProperty = skuPropertyService.selectByPrimaryKey(skuPropertyId);
		List<SkuPropertyValue> skuPropertyValue = skuPropertyService.getSkuPropertyValue(skuPropertyId);
		model.addAttribute("skuPropertyValue", skuPropertyValue);
		model.addAttribute("skuProperty", skuProperty);
		return "product/sku_property_value_table";
		
	}
	
	/**
	 * 生成sku列表
	 * @param model
	 * @param vo
	 * @return
	 */
	@RequestMapping(value = "/generateSku",method = RequestMethod.POST)
	public String generateSkuList(Model model, @RequestBody SkuGenerateFormVo vo){
		List<Map<String,Object>> skuList = productSkuService.generateSku(vo);
		model.addAttribute("skuList", skuList);
		model.addAttribute("skuPropertieList", vo.getSkuPropertieList());
		return "product/sku_form";
	}


	
	/**
	 * 保存商品SKU
	 * @return
	 */
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	@ResponseBody
	public JSONResult productSkuSave(ProductVo vo){
		JSONResult jsonResult = new JSONResult();
		try {
			productSkuService.save(vo);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			jsonResult.setErrorMsg(e.getMessage());
		}
		return jsonResult;
	}
	
}








