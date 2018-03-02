package net.lainiao.myqq.model;

/**
 * Created by Administrator on 2018/2/25.
 */
public class GetSysMessResponseModel extends CommonResponseModel {
    //来源0系统 其他是其他用户的产生的
    private int fromId;
    private String fromNickName;
    //0 系统 1申请加好友 2同意好友申请 3拒绝好友申请 4好友下线 5好友上线

    public int getFromId() {
        return fromId;
    }

    public void setFromId(int fromId) {
        this.fromId = fromId;
    }

    public String getFromNickName() {
        return fromNickName;
    }

    public void setFromNickName(String fromNickName) {
        this.fromNickName = fromNickName;
    }

    public int getSysMessType() {
        return sysMessType;
    }

    public void setSysMessType(int sysMessType) {
        this.sysMessType = sysMessType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private int sysMessType;
    //消息内容
    private String content;
    private int faceimg;

    public int getFaceimg() {
        return faceimg;
    }

    public void setFaceimg(int faceimg) {
        this.faceimg = faceimg;
    }
}
