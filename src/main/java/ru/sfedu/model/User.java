package ru.sfedu.model;

import com.opencsv.bean.CsvBindByPosition;
import org.simpleframework.xml.Root;import com.opencsv.bean.CsvBindByName;

import ru.sfedu.Constants;

import java.io.Serializable;
import java.util.Objects;


/**
 * Class User
 */
@Root(name = "User")
public class User {

    @CsvBindByPosition(position = 0)
    private long id;

    @CsvBindByPosition(position = 1)
    private String name;

    @CsvBindByPosition(position = 2)
    private String mobNum;

    @CsvBindByPosition(position = 3)
    private String email;


    /**
     * Instantiates a new Users.
     */
    public User(){}

    /**
     *new Users
     *
     * @param id            the userId
     * @param name          the name
     * @param mobNum        the mobNum
     * @param email         the is email
     */
    public User(long id, String name, String mobNum, String email) {
        this.id = id;
        this.name = name;
        this.mobNum = mobNum;
        this.email = email;
    }

    /**
     * Get id
     * @return the id
     */
    public long getUserById() {
        return id;
    }

    /**
     * Set userId
     * @param id the id
     */
    public void setUserId(long id) {
        this.id = id;
    }

    /**
     * Get userName
     * @return the userName
     */
    public String getUserName() {
        return name;
    }

    /**
     * Set userName
     * @param userName the address
     */
    public void setUserName(String userName) {
        this.name = userName;
    }

    /**
     * Get mobNum
     * @return the mobNum
     */
    public String getMobNum() {
        return mobNum;
    }

    /**
     * Set mobNum
     * @param mobNum the phone
     */
    public void setMobNum(String mobNum) {
        this.mobNum = mobNum;
    }

    /**
     * Get email
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set email
     * @param email the phone
     */
    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User users = (User) o;
        return id == users.id &&
                getUserName().equals(users.getUserName()) &&
                getMobNum().equals(users.getMobNum()) &&
                getEmail().equals(users.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, getUserName(), getMobNum(), getEmail());
    }

    @Override
    public String toString() {
        return "Users" +
                "userId=" + id +
                ", userName='" + name + '\'' +
                ", mobNum='" + mobNum + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}