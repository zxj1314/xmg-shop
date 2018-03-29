package com.seemygo.client.mgrsite.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.seemygo.shop.api.goods.domain.Catalog;
import com.seemygo.shop.api.goods.service.ICatalogService;
import com.seemygo.shop.api.goods.util.JSONResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/catalog")
public class CatalogController {

	@Reference
	ICatalogService catalogService;

	
	/**
	 * 进入分类管理界面
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String catalog(Model model){
		
		return "catalog/catalog";
	}
	
	/**
	 * 通过分类ID获取子分类（用于分类树显示）
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/get")
	@ResponseBody
	public List<Catalog> getCatalog(Long id){
		List<Catalog> list = catalogService.getChildenCatalogById(id);
		return list;
	}
	
	/**
	 * 保存分类
	 * @param catalog
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public JSONResult catalogSave(Catalog catalog){
		JSONResult jsonResult = new JSONResult();
		try {
			if(catalog.getId() == null){
				
				catalogService.insert(catalog);
			}
			else{
				Catalog catalogDb = catalogService.selectByPrimaryKey(catalog.getId());
				catalogDb.setCode(catalog.getCode());
				catalogDb.setName(catalog.getName());
				catalogDb.setLastModifiedDate(new Date());
				catalogService.updateByPrimaryKey(catalogDb);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			jsonResult.setErrorMsg(e.getMessage());
		}
		return jsonResult;
		
	}
	
	/**
	 * 返回分类编辑面板
	 * @param catalogId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/add/{catalogId}",method = RequestMethod.GET)
	public String catalogInput(@PathVariable("catalogId") Long catalogId, Model model){
		Catalog catalog = catalogService.selectByPrimaryKey(catalogId);
		model.addAttribute("catalog", catalog);
		return "catalog/catalog_input";
	}
	
	@RequestMapping(value = "/delete/{catalogId}",method = RequestMethod.GET)
	@ResponseBody
	public JSONResult deleteCatalog(@PathVariable("catalogId")Long catalogId){
		JSONResult jsonResult = new JSONResult();
		try {
			catalogService.deleteByPrimaryKey(catalogId);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			jsonResult.setErrorMsg(e.getMessage());
		}
		return jsonResult;
		
	}

}






