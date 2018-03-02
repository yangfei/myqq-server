package net.lainiao.myqq.model;

/**
 * Created by Administrator on 2018/2/25.
 */
public class GetFriendsRequestModel extends CommonRequestModel {
    public int targetId;

    public int getTargetId() {
        return targetId;
    }

    public void setTargetId(int targetId) {
        this.targetId = targetId;
    }
}
