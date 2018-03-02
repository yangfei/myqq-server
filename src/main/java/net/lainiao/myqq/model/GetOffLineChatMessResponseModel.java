package net.lainiao.myqq.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * Created by Administrator on 2018/2/25.
 */
public class GetOffLineChatMessResponseModel extends CommonResponseModel {
    private int fromid;
    private String nickName;
    private int faceimg;

    public int getFaceimg() {
        return faceimg;
    }

    public void setFaceimg(int faceimg) {
        this.faceimg = faceimg;
    }

    private int ChatMessType;
    private String content;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createtime;

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public int getFromid() {
        return fromid;
    }

    public void setFromid(int fromid) {
        this.fromid = fromid;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getChatMessType() {
        return ChatMessType;
    }

    public void setChatMessType(int chatMessType) {
        ChatMessType = chatMessType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
