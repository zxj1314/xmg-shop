package com.seemygo.shop.api.goods.query;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zlb on 2017.10.10.
 */
@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PageResult implements Serializable{

    private List<?> list;
    private Integer totalCount;
    private Integer currentPage;
    private Integer prevPage;//上一页
    private Integer nextPage;//下一页
    private Integer endPage;//尾页
    private Integer pageSize;//每页的数据条数
    private Integer totalPage;
    public PageResult(List<?> list, Integer totalCount, Integer currentPage,Integer pageSize) {
        this.list = list;
        this.totalCount=totalCount;
        this.currentPage =currentPage;
        this.pageSize= pageSize;
        this.totalPage = totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
        this.prevPage = currentPage-1>=1?currentPage-1:1;
        this.nextPage = currentPage+1<=totalPage?currentPage+1:totalPage;
        this.endPage =totalPage;
    }

    public static PageResult empty(Integer pageSize){
        return new PageResult(new ArrayList(),0,1,pageSize);
    }
}
