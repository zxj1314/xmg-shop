package com.seemygo.server.goods.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.seemygo.server.goods.mapper.ProductSkuMapper;
import com.seemygo.server.goods.mapper.ProductSkuPropertyMapper;
import com.seemygo.shop.api.goods.domain.*;
import com.seemygo.shop.api.goods.service.ICatalogService;
import com.seemygo.shop.api.goods.service.IProductService;
import com.seemygo.shop.api.goods.service.IProductSkuService;
import com.seemygo.shop.api.goods.vo.ProductVo;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductSkuServiceImpl implements IProductSkuService {

	@Autowired
	ProductSkuMapper productSkuDao;
	
	@Autowired
	ICatalogService catalogService;
	
	@Autowired
	IProductService productService;
	
	@Autowired
	ProductSkuPropertyMapper productSkuPropertyDao;
	
	@Override
	public int deleteByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return productSkuDao.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(ProductSku record) {
		// TODO Auto-generated method stub
		return productSkuDao.insert(record);
	}

	@Override
	public ProductSku selectByPrimaryKey(Long id) {
		// TODO Auto-generated method stub
		return productSkuDao.selectByPrimaryKey(id);
	}

	@Override
	public List<ProductSku> selectAll() {
		// TODO Auto-generated method stub
		return productSkuDao.selectAll();
	}

	@Override
	public int updateByPrimaryKey(ProductSku record) {
		// TODO Auto-generated method stub
		return productSkuDao.updateByPrimaryKey(record);
	}

	@Override
	public List<ProductSku> getSkuByProductId(Long productId) {
		// TODO Auto-generated method stub
		return productSkuDao.getSkuByProductId(productId);
	}

	/**
	 * 生成sku
	 * @param vo
	 * @return
	 */
	@Override
	public List<Map<String, Object>> generateSku(SkuGenerateFormVo vo) {
		
		//获取商品对象
		Product product = productService.selectByPrimaryKey(vo.getProductId());
		
		//sku属性列表
		List<SkuProperty> skuPropertieList = vo.getSkuPropertieList();
		
		//sku属性值列表
		List<SkuPropertyValue> skuPropertyValueList = vo.getSkuPropertyValueList();
		
		//获取sku编码前缀
		String skuCodePrefix = getSkuCodePrefix(product.getCatalog().getId());
		
		//获取Map<Long, List<SkuPropertyValue>>结果集，key为属性ID，值为该属性ID下的属性值列表
		Map<Long, List<SkuPropertyValue>> skuPropertyAndValueMap = getSkuPropertyAndValueMap(skuPropertieList,skuPropertyValueList);
		
		//Map<Long, List<SkuPropertyValue>>转为List<List<String>>,用于递归的使用
		List<List<SkuPropertyValue>> handleList = new ArrayList<List<SkuPropertyValue>>();
		for (SkuProperty skuProperty : skuPropertieList) {
			handleList.add(skuPropertyAndValueMap.get(skuProperty.getId()));
		}
		
		//递归结果集
		List <List<String>> recursiveResult = new ArrayList<List<String>>();
		
		//递归操作
		recursive(recursiveResult,handleList,0,new ArrayList<String>());
		
		//最终需要在页面显示的结果，存放的数据格式如下面的实例：{颜色=白, 尺寸=S, code=CL03010}
		List<Map<String, Object>> pageResult = new ArrayList<Map<String,Object>>();
		for (int i = 0; i < recursiveResult.size(); i++) {
			
			Map<String, Object> map = new HashMap();
			
			//sku编码(前台可以改)
		    map.put("code", skuCodePrefix + i);
		    
		    //sku属性
		    for (int j = 0; j < recursiveResult.get(i).size(); j++) {
		    	//因为recursiveResult的值是根据前台提交的skuPropertieList属性集合生成的，所以顺序一样的，
		    	//如：[白，L]，白的值对应的角标是0，黑对应的角标是1，skuPropertieList里也是[颜色，尺码]颜色角标0，尺码角标1
		        map.put(skuPropertieList.get(j).getName(), recursiveResult.get(i).get(j));
		    }
		    
		    //sku价格(前台可以改)
		    map.put("price", product.getBasePrice());
		    pageResult.add(map);
		}
		System.out.println(pageResult);
		
		return pageResult;
	}

	/**
	 * 
	 * @param recursiveResult 递归的结果集
	 * @param handleList	     需要递归操作的集合
	 * @param layer			     递归的层级（sku属性的个数等于layer的层级数）
	 * @param contentList	     结果集里的元素集合	
	 */
	private void recursive(List<List<String>> recursiveResult,
			List<List<SkuPropertyValue>> handleList, int layer,
			ArrayList<String> contentList) {
		// TODO Auto-generated method stub
		//判断层级是否在handleList的最后一个元素
		if(layer < handleList.size() - 1){
			//不是最后一个元素
			for (int i = 0; i < handleList.get(layer).size(); i++) {
				//以递归传递的contentList为基础，构建一个新的list，这样上一层递归的数据才不会丢失
				ArrayList<String> arrayList = new ArrayList<String>(contentList);
				
				arrayList.add(handleList.get(layer).get(i).getValue());
				
				//递归调用自己
				recursive(recursiveResult,handleList,layer+1,arrayList);
			}
			
		}else if(layer == handleList.size() - 1){
			//是最后一个元素
			for (int i = 0; i < handleList.get(layer).size(); i++) {
				
                List<String> arrayList = new ArrayList<String>(contentList);
                
                arrayList.add(handleList.get(layer).get(i).getValue());
                
                //添加到递归结果集中，结束这次层级的递归
                recursiveResult.add(arrayList);
            }
		}
	}

	/**
	 * sku编码的生成规则是2位商品一级分类缩写+2位商品二级分类顺序+2为商品三级分类顺序+商品ID+该SKU在整个SKU笛卡尔积的位置
	 * 获取sku编码前缀
	 * @param catalogId
	 * @return
	 */
	private String getSkuCodePrefix(Long catalogId) {
		// TODO Auto-generated method stub
		//获取当前的分类
		Catalog catalog = catalogService.selectByPrimaryKey(catalogId);
		
		Long parentCatalogId = catalog.getParentCatalogId();
		
		StringBuilder sb = new StringBuilder();
		
		//如果分类所在的序号小于10的话，给序号前面加上0，凑成2为数
		String skuCodePrefix = catalog.getSequence() > 9 ? "" + catalog.getSequence() : "0"+catalog.getSequence();
		
		//先定义一个sku编号前缀的前两位分类编号缩写
		String catalogCode = catalog.getCode().substring(0,2).toUpperCase();
		
		//循环获取当前分类的父分类，直到顶级分类就介绍循环
		while(true){
			
			//获取当前分类的父分类
			Catalog catalogParent = catalogService.selectByPrimaryKey(parentCatalogId);
			
			if(catalogParent == null){
				
				break;
			}
			
			//拼接sku编号前缀
			skuCodePrefix = catalogParent.getSequence() > 9 ? "" + catalogParent.getSequence() : "0"+catalogParent.getSequence() + skuCodePrefix;
			
			//重新给父分类ID赋值
			parentCatalogId = catalogParent.getParentCatalogId();
			
			//重新给sku编号前缀的前两位分类编号缩写赋值
			catalogCode = catalogParent.getCode().substring(0,2).toUpperCase();
		}
		
		//把sku编号前缀的前两位分类序号替换成编号
		skuCodePrefix = catalogCode + skuCodePrefix.substring(2, skuCodePrefix.length());
		return skuCodePrefix;
	}

	/**
	 * Map<Long, List<SkuPropertyValue>>结果集，key为属性ID，值为该属性ID下的属性值列表
	 * @param
	 * @return
	 */
	private Map<Long, List<SkuPropertyValue>> getSkuPropertyAndValueMap(
			List<SkuProperty> skuPropertieList,
			List<SkuPropertyValue> skuPropertyValueList) {
		
		//定义一个map，用于存储List<SkuPropertyValue>通过skuPropertyId分类统计的结果
		Map<Long, List<SkuPropertyValue>> skuPropertyAndValueMap = new HashMap<Long,List<SkuPropertyValue>>();
		
		for (int i = 0; i < skuPropertieList.size(); i++) {
			
			//SkuProperty对象里的skuPropertyId
			Long skuPropertyId = skuPropertieList.get(i).getId();
			//判断SkuPropertyValueMap里有无sku属性ID
			if(!skuPropertyAndValueMap.containsKey(skuPropertyId)){
				//没有的话添加一个以sku属性ID为key的list
				skuPropertyAndValueMap.put(skuPropertyId,new ArrayList<SkuPropertyValue>());
			}
			
			
			for (int j = 0; j < skuPropertyValueList.size(); j++) {
				//SkuPropertyValue对象里的skuPropertyId
				Long skuPropertyIdOfValue = skuPropertyValueList.get(j).getSkuProperty().getId();
				//如果当前遍历到的属性值里的属性ID于外循环里的属性ID相同，就添加到SkuPropertyValueMap里
				if(skuPropertyId.equals(skuPropertyIdOfValue)){
					
					skuPropertyAndValueMap.get(skuPropertyId).add(skuPropertyValueList.get(j));
				}
			}
		}
		return skuPropertyAndValueMap;
	}

	/**
	 * 保存sku
	 */
	@Override
	public void save(ProductVo vo) {
		//保存商品sku（该代码废弃）
		List<ProductSku> productSkuList = vo.getProductSkuList();
		for (ProductSku productSku : productSkuList) { 
			productSku.setMods(1L);
			productSku.setProduct(vo.getProduct());
			productSkuDao.insert(productSku);
			
			//获取sku中的属性列表
			List<ProductSkuProperty> productSkuPropertyList = productSku.getProductSkuPropertyList();
			for (ProductSkuProperty productSkuProperty : productSkuPropertyList) {
				productSkuProperty.setProductSkuId(productSku.getId());
				//保存sku中的属性列表
				productSkuPropertyDao.insert(productSkuProperty);
			}
		}
	}
}
