package com.seemygo.client.mgrsite.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.seemygo.shop.api.goods.domain.Catalog;
import com.seemygo.shop.api.goods.domain.SkuProperty;
import com.seemygo.shop.api.goods.service.ICatalogService;
import com.seemygo.shop.api.goods.service.ISkuPropertyService;
import com.seemygo.shop.api.goods.util.JSONResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * sku属性管理
 * @author luohaipeng
 *
 */
@Controller
@RequestMapping("/skuProperty")
public class SkuPropertyController {

	@Reference
	ISkuPropertyService skuPropertyService;

	@Reference
	ICatalogService catalogService;
	
	/**
	 * 进入sku属性管理界面
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String skuProperty(Model model){
		
		return "sku/property";
	}

	@RequestMapping(value = "gets",method = RequestMethod.POST)
	@ResponseBody
	public List<Catalog> getCatalog(Long id){
		List<Catalog> list = catalogService.getChildenCatalogById(id);
		return list;
	}
	
	
	/**
	 * 通过分类ID获取分类属性,返回分类属性列表
	 * @param catalogId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
	public String getSkuProperty(@PathVariable("id") Long catalogId, Model model){
		List<SkuProperty> list = skuPropertyService.getSkuProperty(catalogId);
		model.addAttribute("list", list);
		return "sku/property_list";
	}
	
	/**
	 * 新增sku属性
	 * @param skuProperty
	 * @return
	 */
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	@ResponseBody
	public JSONResult addSkuProperty(SkuProperty skuProperty){
		JSONResult jSONResult = new JSONResult();
		try {
			if(skuProperty.getId() == null || skuProperty.getId() == -1){
				
				skuProperty.setSequence(0);
				skuPropertyService.insert(skuProperty);
			}else{
				SkuProperty skuPropertyDb = skuPropertyService.selectByPrimaryKey(skuProperty.getId());
				skuPropertyDb.setName(skuProperty.getName());
				skuPropertyDb.setType(skuProperty.getType());
				skuPropertyService.updateByPrimaryKey(skuPropertyDb);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			jSONResult.setErrorMsg(e.getMessage());
		}
		return jSONResult;
		
	}

	/**
	 * 新增sku属性界面
	 * @param model
	 * @param skuProperty
	 * @return
	 */
	@RequestMapping(value = "/save",method = RequestMethod.GET)
	public String toPropertySave(Model model, SkuProperty skuProperty){
		if(skuProperty.getId() != -1){
			
			skuProperty = skuPropertyService.selectByPrimaryKey(skuProperty.getId());
		}
		model.addAttribute("skuProperty", skuProperty);
		return "sku/property_save";
	}

	/**
	 * 删除sku属性
	 * @param skuProperty
	 * @return
	 */
	@RequestMapping(value = "/delete",method = RequestMethod.GET)
	public String deleteSkuProperty(SkuProperty skuProperty){
		skuPropertyService.deleteByPrimaryKey(skuProperty.getId());
		
		return "redirect:/skuProperty/get/"+skuProperty.getCatalogId();
	}
}
