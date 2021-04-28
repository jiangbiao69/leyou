package com.leyou.common.pojo;

import java.util.List;
/*
* @江彪
* 分页结果集，如：查询品牌，网页进行分页展示，会用到。
* 我们把分页结果集定义在common中，是为了面向所有微服务，因为其他微服务可能也需要调用分页结果集
*/

public class PageResult<T> {  //因为下面用到了泛型，所以这里在类名后进行声明 PageResult<T>
    private Long total;// 总条数
    private Integer totalPage;// 总页数
    private List<T> items;// 当前页数据

    public PageResult() {
    }

    public PageResult(Long total, List<T> items) {
        this.total = total;
        this.items = items;
    }

    public PageResult(Long total, Integer totalPage, List<T> items) {
        this.total = total;
        this.totalPage = totalPage;
        this.items = items;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
