package ru.sfedu.lab3CSV;

import com.opencsv.bean.CsvBindByName;
import ru.sfedu.Constants;

import java.io.Serializable;
import java.util.Objects;

//@Entity
// @Table(name= Constants.NAME_TABLE_PROFILE)

public class Users implements Serializable {

    @CsvBindByName(column = Constants.PROFILE_USER_ID)
    private long userId;

    @CsvBindByName(column =Constants.PROFILE_USER_NAME)
    private String userName;

    @CsvBindByName(column =Constants.PROFILE_MOB_NUM)
    private String mobNum;

    @CsvBindByName(column =Constants.PROFILE_EMAIL)
    private String email;


    public Users(){}


    public Users(long userId, String userName, String mobNum, String email) {
        this.userId = userId;
        this.userName = userName;
        this.mobNum = mobNum;
        this.email = email;
    }


    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobNum() {
        return mobNum;
    }

    public void setMobNum(String mobNum) {
        this.mobNum = mobNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Users)) return false;
        Users users = (Users) o;
        return userId == users.userId &&
                getUserName().equals(users.getUserName()) &&
                getMobNum().equals(users.getMobNum()) &&
                getEmail().equals(users.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, getUserName(), getMobNum(), getEmail());
    }


}