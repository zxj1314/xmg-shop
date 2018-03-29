package com.seemygo.shop.api.goods.query;


/**
 * Created by Hanson on 2017/10/10.
 */
import org.springframework.util.StringUtils;
public class BrandQueryObject extends QueryObject {


    private String keyword;
    public String getString() {

        return StringUtils.hasLength(keyword) ? keyword : null;
    }

    public void setString(String string) {
        this.keyword = keyword;
    }


}
