package net.lainiao.myqq.model;

/**
 * Created by Administrator on 2018/2/25.
 */
public class GetFriendsResponseModel extends CommonResponseModel {
    private int friendid;
    private String nickName;
    private int lineState;
    private int faceimg;

    public int getFaceimg() {
        return faceimg;
    }

    public void setFaceimg(int faceimg) {
        this.faceimg = faceimg;
    }

    public int getFriendid() {
        return friendid;
    }

    public void setFriendid(int friendid) {
        this.friendid = friendid;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getLineState() {
        return lineState;
    }

    public void setLineState(int lineState) {
        this.lineState = lineState;
    }
}
