package com.example.demo.domain;

/**
 * Page
 *
 * @author liujinliang
 * @date 2019/5/23
 **/
public class Page {
    private int page;
    private int limit;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
