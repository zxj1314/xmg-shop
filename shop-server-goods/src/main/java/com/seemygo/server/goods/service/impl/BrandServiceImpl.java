package com.seemygo.server.goods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.seemygo.server.goods.mapper.BrandMapper;
import com.seemygo.shop.api.goods.domain.Brand;
import com.seemygo.shop.api.goods.query.BrandQueryObject;
import com.seemygo.shop.api.goods.query.PageResult;
import com.seemygo.shop.api.goods.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Hanson on 2017/10/10.
 */
@Service
public class BrandServiceImpl implements IBrandService {
    @Autowired
    private BrandMapper brandMapper;
    @Override
    public int deleteByPrimaryKey(Long id) {
        return 0;
    }

    @Override
    public int insert(Brand record) {
        return 0;
    }

    @Override
    public Brand selectByPrimaryKey(Long id) {
        return null;
    }

    @Override
    public List<Brand> selectAll() {
        return brandMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Brand record) {
        return 0;
    }

    @Override
    public PageResult query(BrandQueryObject qo) {
        int count = brandMapper.queryForCount(qo);
        if (count <= 0){
            return PageResult.empty(qo.getPageSize());
        }
        List<Brand> list = brandMapper.queryForList(qo);
        return new PageResult(list,count,qo.getCurrentPage(),qo.getPageSize());
    }
}
