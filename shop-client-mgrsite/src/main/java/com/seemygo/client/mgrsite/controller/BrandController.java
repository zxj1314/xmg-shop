package com.seemygo.client.mgrsite.controller;

/**
 * Created by Hanson on 2017/10/9.
 */

import com.alibaba.dubbo.config.annotation.Reference;
import com.seemygo.shop.api.goods.query.BrandQueryObject;
import com.seemygo.shop.api.goods.service.IBrandService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 品牌管理
 */
@Controller
public class BrandController {

    @Reference
    private IBrandService brandService;

    @RequestMapping(value = "/brand")
    public String brandList(@ModelAttribute("qo") BrandQueryObject qo, Model model){
        model.addAttribute("pageResult",brandService.query(qo));
        return "product/brand_list";
    }

}
