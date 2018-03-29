package com.seemygo.shop.api.goods.query;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by zlb on 2017.10.10.
 */
@Getter
@Setter
public class ProductQueryObject extends QueryObject implements Serializable{
    private String keyword;

    public String getKeyword(){
        return keyword==""?null:keyword;
    }
}
