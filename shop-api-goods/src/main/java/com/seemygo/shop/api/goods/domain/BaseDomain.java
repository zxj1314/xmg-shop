package com.seemygo.shop.api.goods.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by Hanson on 2017/10/9.
 */
@Setter
@Getter
public class BaseDomain implements Serializable {
    private static final long serialVersionUID = 1L;

    protected Long id;
}
