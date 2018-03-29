package com.seemygo.client.mgrsite.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.seemygo.shop.api.goods.domain.CatalogProperty;
import com.seemygo.shop.api.goods.service.ICatalogPropertyService;
import com.seemygo.shop.api.goods.util.JSONResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/catalogProperty")
public class CatalogPropertyController {

	@Reference
	ICatalogPropertyService catalogPropertyService;
	
	/**
	 * 进入分类属性管理界面
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String catalogProperty(Model model){
		
		return "property/property";
	}
	
	
	/**
	 * 通过分类ID获取分类属性,返回分类属性列表
	 * @param catalogId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/get/{catalogId}",method = RequestMethod.GET)
	public String getCatalogProperty(@PathVariable("catalogId") Long catalogId,Model model){
		List<CatalogProperty> list = catalogPropertyService.getCatalogProperty(catalogId);
		model.addAttribute("list", list);
		return "property/property_list";
	}
	/**
	 * 通过商品选择的分类，获取分类属性和对应的分类属性值，返回商品属性面板
	 * @return
	 */
	//@RequestMapping("/getCatalogPropertyPanel.do")
	/*@RequestMapping(value = "/propertyValue/get/{catalogId}",method = RequestMethod.GET)
	public String getCatalogProperty(Model model, @PathVariable("catalogId") Long catalogId){

		List<ProductCatalogPropertyVo> productCatalogPropertyList = new ArrayList<ProductCatalogPropertyVo>();

		List<CatalogProperty> catalogPropertyList = catalogPropertyService.getCatalogProperty(catalogId);

		for (CatalogProperty catalogProperty : catalogPropertyList) {

			ProductCatalogPropertyVo productCatalogPropertyVo = new ProductCatalogPropertyVo();

			productCatalogPropertyVo.setCatalogPropertyName(catalogProperty.getName());

			productCatalogPropertyVo.setType(catalogProperty.getType());

			List<CatalogPropertyValue> catalogPropertyValue = catalogPropertyService.getCatalogPropertyValue(catalogProperty.getId());

			productCatalogPropertyVo.setPropertyValueList(catalogPropertyValue);

			productCatalogPropertyList.add(productCatalogPropertyVo);
		}
		model.addAttribute("productCatalogPropertyList",productCatalogPropertyList);
		return "product/catalog_property_panel";
	}
*/

	/**
	 * 新增分类属性
	 * @param catalogProperty
	 * @return
	 */
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	@ResponseBody
	public JSONResult addCatalogProperty(CatalogProperty catalogProperty){
		JSONResult jSONResult = new JSONResult();
		try {
			if(catalogProperty.getId() == null || catalogProperty.getId() == -1){
				
				catalogProperty.setSequence(0);
				catalogPropertyService.insert(catalogProperty);
			}else{
				CatalogProperty catalogPropertyDb = catalogPropertyService.selectByPrimaryKey(catalogProperty.getId());
				catalogPropertyDb.setName(catalogProperty.getName());
				catalogPropertyDb.setType(catalogProperty.getType());
				catalogPropertyService.updateByPrimaryKey(catalogPropertyDb);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			jSONResult.setErrorMsg(e.getMessage());
		}
		return jSONResult;
		
	}

    /**
     * 新增分类属性界面
     * @param model
     * @param catalogProperty
     * @return
     */
	@RequestMapping(value = "/add",method = RequestMethod.GET)
	public String toPropertySave(Model model, CatalogProperty catalogProperty){
		if(catalogProperty.getId() != null && catalogProperty.getId() != -1){
			
			catalogProperty = catalogPropertyService.selectByPrimaryKey(catalogProperty.getId());
		}
		model.addAttribute("catalogProperty", catalogProperty);
		return "property/property_save";
	}
	
	@RequestMapping(value = "/delete",method = RequestMethod.GET)
	public String deleteCatalogProperty(CatalogProperty catalogProperty){
		catalogPropertyService.deleteByPrimaryKey(catalogProperty.getId());
		
		return "redirect:/catalogProperty/get/"+catalogProperty.getCatalogId();
	}
}






