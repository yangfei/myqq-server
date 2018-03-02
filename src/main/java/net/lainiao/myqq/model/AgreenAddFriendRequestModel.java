package net.lainiao.myqq.model;

/**
 * Created by Administrator on 2018/2/25.
 */
public class AgreenAddFriendRequestModel extends CommonRequestModel {
    private int targetId;
    private int result;
    private String resultMess;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getResultMess() {
        return resultMess;
    }

    public void setResultMess(String resultMess) {
        this.resultMess = resultMess;
    }

    public int getTargetId() {
        return targetId;
    }

    public void setTargetId(int targetId) {
        this.targetId = targetId;
    }
}
