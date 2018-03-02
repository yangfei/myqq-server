package net.lainiao.myqq.model;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

public class LoginResponseModel  extends CommonResponseModel  {
    private String username;

    private Integer age;

    private String gender;

    private String nickname;

    private String conste;

    private String blood;
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    private Date createtime;
    private int id;
    private int lineState;
    private int faceimg;

    public int getFaceimg() {
        return faceimg;
    }

    public void setFaceimg(int faceimg) {
        this.faceimg = faceimg;
    }

    public int getLineState() {
        return lineState;
    }

    public void setLineState(int lineState) {
        this.lineState = lineState;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getConste() {
        return conste;
    }

    public void setConste(String conste) {
        this.conste = conste;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
