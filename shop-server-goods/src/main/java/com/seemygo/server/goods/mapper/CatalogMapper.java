package com.seemygo.server.goods.mapper;

import com.seemygo.shop.api.goods.domain.Catalog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CatalogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Catalog record);

    Catalog selectByPrimaryKey(Long id);

    List<Catalog> selectAll();

    int updateByPrimaryKey(Catalog record);

	List<Catalog> getChildenCatalogById(@Param("parentId") Long parentId);

}