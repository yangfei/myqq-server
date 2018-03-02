package net.lainiao.myqq.model;

public class AddFriendRequestModel extends CommonRequestModel {
    private int targetId;
    private String mess;

    public int getTargetId() {
        return targetId;
    }

    public void setTargetId(int targetId) {
        this.targetId = targetId;
    }

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }
}
