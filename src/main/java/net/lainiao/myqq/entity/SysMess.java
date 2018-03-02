package net.lainiao.myqq.entity;

import java.io.Serializable;
import java.util.Date;

public class SysMess implements Serializable {
    private Integer id;
    //0 系统 1申请加好友 2同意好友申请 3拒绝好友申请 4好友下线 5好友上线
    private Integer messtype;

    private Integer fromid;

    private Integer targetid;

    private String content;

    private Date createtime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMesstype() {
        return messtype;
    }

    public void setMesstype(Integer messtype) {
        this.messtype = messtype;
    }

    public Integer getFromid() {
        return fromid;
    }

    public void setFromid(Integer fromid) {
        this.fromid = fromid;
    }

    public Integer getTargetid() {
        return targetid;
    }

    public void setTargetid(Integer targetid) {
        this.targetid = targetid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", messtype=").append(messtype);
        sb.append(", fromid=").append(fromid);
        sb.append(", targetid=").append(targetid);
        sb.append(", content=").append(content);
        sb.append(", createtime=").append(createtime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}