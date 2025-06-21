package nic.rti.master.entity;

import jakarta.persistence.*;

@Entity
@Table(schema = "RTIMIS", name = "mas_user")
public class MasUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_name")
    private String userName;

    public MasUser() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "MasUser{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
