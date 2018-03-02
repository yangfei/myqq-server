package net.lainiao.myqq.model;

import java.util.List;

public class DataList<T> {
    public DataList(int pageSize,int total){
        this.pageSize=pageSize;
        this.total=total;
        this.pageCount= total%pageSize==0?total/pageSize:total/pageSize+1;
    }

    public DataList(){

    }
    private int total;
    private int pageCount;
    private int pageIndex;
    private int pageSize;
    private List<T> data;

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
