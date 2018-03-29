package com.seemygo.client.mgrsite.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.seemygo.shop.api.goods.domain.SkuProperty;
import com.seemygo.shop.api.goods.domain.SkuPropertyValue;
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
@RequestMapping("/skuPropertyValue")
public class SkuPropertyValueController {

	@Reference
	ISkuPropertyService skuPropertyService;

	/**
	 * 通过sku属性ID获取sku属性值
	 * @param skuPropertyId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/get/{skuPropertyId}",method = RequestMethod.GET)
	public String getSkuPropertyValue(@PathVariable("skuPropertyId") Long skuPropertyId,Model model){
		SkuProperty skuProperty = skuPropertyService.selectByPrimaryKey(skuPropertyId);
		List<SkuPropertyValue> skuPropertyValueList = skuPropertyService.getSkuPropertyValue(skuPropertyId);
		model.addAttribute("list", skuPropertyValueList);
		model.addAttribute("skuProperty", skuProperty);
		return "sku/property_value_list";
	}

	/**
	 * 新增sku属性值
	 */
	@RequestMapping(value = "/add",method = RequestMethod.POST)
	@ResponseBody
	public JSONResult addSkuPropertyValue(SkuPropertyValue skuPropertyValue){
		JSONResult jSONResult = new JSONResult();
		try {

			skuPropertyValue.setSequence(0);
			skuPropertyService.insertPropertyValue(skuPropertyValue);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			jSONResult.setErrorMsg(e.getMessage());
		}
		return jSONResult;

	}
}
