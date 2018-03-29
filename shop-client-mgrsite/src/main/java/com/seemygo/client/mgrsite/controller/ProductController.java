package com.seemygo.client.mgrsite.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.seemygo.client.mgrsite.util.UploadUtil;
import com.seemygo.shop.api.goods.domain.*;
import com.seemygo.shop.api.goods.query.PageResult;
import com.seemygo.shop.api.goods.query.ProductQueryObject;
import com.seemygo.shop.api.goods.service.*;
import com.seemygo.shop.api.goods.util.JSONResult;
import com.seemygo.shop.api.goods.vo.ProductVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * Created by zlb on 2017.09.29.
 */
@Controller
@RequestMapping("/product")
public class ProductController {
    @Reference
    private ServletContext servletContext;
    @Reference
    private IProductService productService;
    @Reference
    private IBrandService brandService;
    @Reference
    private ICatalogService catalogService;
    @Reference
    private IProductDescService productDescService;
    @Reference
    IProductImageService productImageService;
    @Reference
    IProductCatalogPropertyValueService productCatalogPropertyValueService;
    @Reference
    private IProductSkuService productSkuService;;

    /**进入商品页面
     * @param model
     * @return
     */
    @RequestMapping("/get")
    public String getProduct(@ModelAttribute("qo")ProductQueryObject qo, Model model){
        PageResult pageResult= productService.query(qo);
        model.addAttribute("pageResult",pageResult);
        return  "product/product_list";
    }

    /*@RequestMapping("/getProduct")
    @ResponseBody
    public List<Product> getAllProduct(){
        List<Product> list = productService.getAllProcudt();
        return list;
    }*/

    /**商品新增列表页面
     * @param model
     * @return
     */
    @RequestMapping(value="/add",method = RequestMethod.GET)
    public String productAddList(Model model){
        List<Brand> brands = brandService.selectAll();
        List<Catalog> catalogs = catalogService.selectAll();
        model.addAttribute("brands",brands);
        model.addAttribute("catalogs",catalogs);
        return  "product/product_input";
    }

    /**保存商品
     * @param vo
     * @return
     */
    @RequestMapping(value="/add",method = RequestMethod.POST)
    @ResponseBody
    public JSONResult productSave(ProductVo vo){
        JSONResult jsonResult = new JSONResult();
        try {
            productService.save(vo);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            jsonResult.setErrorMsg(e.getMessage());
        }
        return jsonResult;
    }

    /**
     * 上传商品图片
     * @param file
     * @return
     */
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    @ResponseBody
    public String productImgUpload(MultipartFile file) {
        // 先得到basepath
        String basePath = servletContext.getRealPath("/upload");
        String fileName = UploadUtil.upload(file, basePath);
        return "/upload/" + fileName;
    }

    /**
     * 查看商品详情
     * @param productId
     * @return
     */
    @RequestMapping(value = "/get/{productId}",method = RequestMethod.GET)
    public String showProduct(@PathVariable("productId") Long productId, Model model){

        //商品对象
        Product product = productService.selectByPrimaryKey(productId);
        model.addAttribute("product",product);

        //所有品牌
        List<Brand> brandList = brandService.selectAll();
        model.addAttribute("brands", brandList);

        //所有分类
        List<Catalog> catalogList = catalogService.selectAll();
        model.addAttribute("catalogs", catalogList);

        //商品详细介绍
        ProductDesc productDesc = productDescService.getDescByProductId(product.getId());
        model.addAttribute("productDesc", productDesc);

        //商品相册
        List<ProductImage> productImageList = productImageService.getImageByProductId(product.getId());
        model.addAttribute("productImageList", productImageList);

        //商品属性
        List<ProductCatalogPropertyValue> propertyList = productCatalogPropertyValueService.getPropertyByProductId(productId);
        model.addAttribute("propertyList", propertyList);

        //sku列表
        List<ProductSku> productSkuList = productSkuService.getSkuByProductId(productId);
        model.addAttribute("productSkuList", productSkuList);

        //suk列表里每条sku的sku属性,LinkedHashSet是有序并不重复的
        LinkedHashSet<String> set = new LinkedHashSet<String>();
        for (ProductSku productSku : productSkuList) {
            for (ProductSkuProperty productSkuProperty : productSku.getProductSkuPropertyList()) {

                set.add(productSkuProperty.getSkuProperty().getName());
            }
        }
        model.addAttribute("skuPropertyList", set);

        return "product/show_product";
    }

}
