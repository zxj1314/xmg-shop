package com.seemygo.shop.api.goods.query;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by zlb on 2017.10.10.
 */
@Getter@Setter
public class QueryObject implements Serializable{
    private Integer currentPage=1;
    private Integer pageSize=5;

    public Integer getStartPage(){
        return (currentPage-1)*pageSize;
    }
}
