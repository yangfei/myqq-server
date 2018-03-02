package net.lainiao.myqq.entity;

import java.io.Serializable;
import java.util.Date;

public class Account implements Serializable {
    private Integer id;

    private String username;

    private Integer age;

    private String gender;

    private String userpass;

    private String nickname;

    private String conste;

    private String blood;

    private Date createtime;

    private Integer state;

    private Integer faceimg;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
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
        this.gender = gender == null ? null : gender.trim();
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass == null ? null : userpass.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getConste() {
        return conste;
    }

    public void setConste(String conste) {
        this.conste = conste == null ? null : conste.trim();
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood == null ? null : blood.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getFaceimg() {
        return faceimg;
    }

    public void setFaceimg(Integer faceimg) {
        this.faceimg = faceimg;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", age=").append(age);
        sb.append(", gender=").append(gender);
        sb.append(", userpass=").append(userpass);
        sb.append(", nickname=").append(nickname);
        sb.append(", conste=").append(conste);
        sb.append(", blood=").append(blood);
        sb.append(", createtime=").append(createtime);
        sb.append(", state=").append(state);
        sb.append(", faceimg=").append(faceimg);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}