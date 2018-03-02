package net.lainiao.myqq.model;

public class EditInfoRequestModel extends CommonRequestModel {


    private int age;

    private String gender;

    private String userpass;

    private String nickname;

    private String conste;

    private String blood;

    private int faceimg;

    public int getFaceimg() {
        return faceimg;
    }

    public void setFaceimg(int faceimg) {
        this.faceimg = faceimg;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
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
}
