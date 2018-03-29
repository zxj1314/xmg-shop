package com.seemygo.shop.api.goods.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class Catalog implements Serializable{
    private Long id;

    private Date createDate;

    private Date lastModifiedDate;

    private Integer version;

    private Integer level;

    private String name;

    private String code;

    private Integer sequence;

    private Integer childrenCatalogs;

    private Integer products;

    private Long parentCatalogId;

    private Byte isParent;

}