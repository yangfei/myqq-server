package net.lainiao.myqq.model;

public class SearchFriendResponseModel  extends CommonResponseModel {
    private DataList<LoginResponseModel> dataList;

    public DataList<LoginResponseModel> getDataList() {
        return dataList;
    }

    public void setDataList(DataList<LoginResponseModel> dataList) {
        this.dataList = dataList;
    }

}
