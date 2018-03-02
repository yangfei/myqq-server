package net.lainiao.myqq.model;

/**
 * Created by Administrator on 2018/2/25.
 */
public class SendChatMessRequestModel extends CommonRequestModel {
    private int targetId;
    //0 是私聊 1 是群聊
    private int targetType;
    private String content;

    public int getTargetId() {
        return targetId;
    }

    public void setTargetId(int targetId) {
        this.targetId = targetId;
    }

    public int getTargetType() {
        return targetType;
    }

    public void setTargetType(int targetType) {
        this.targetType = targetType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
