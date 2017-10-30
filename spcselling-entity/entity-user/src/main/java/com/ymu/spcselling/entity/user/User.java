package com.ymu.spcselling.entity.user;

import com.ymu.spcselling.entity.constants.UserType;
import com.ymu.spcselling.entity.constants.UserUsableType;

import javax.persistence.*;
import java.util.Date;

/**
 * 用户基础信息表。
 */
@Entity
public class User extends BaseEntity {

    private static final long serialVersionUID = 7582369102930562542L;

    /**
     * 用户登录名。
     */
    @Column(length = 100, nullable = false,unique = true)
    private String userName;

    /**
     * 登录密码。
     */
    @Column(length = 180, nullable = false)
    private String password;

    /**
     * 手机号码。可用手机号码登录。一个手机号码可以注册多个账号，对应一种用户类型。
     */
    @Column(length = 15, nullable = false)
    private String mobile;

    /**
     * 用户别名。
     */
    @Column(length = 50)
    private String nickName;

    /**
     * 会员类型
     */
    @Column(length = 25, nullable = false)
    @Enumerated(EnumType.STRING)
    private UserType userType;

    /**
     * 会员可用状态
     */
    @Column(length = 25, nullable = false)
    @Enumerated(EnumType.STRING)
    private UserUsableType userUsableType;

    /**
     * 登录状态。1-在线；0-不在线;
     */
    @Column(nullable = false, columnDefinition = "decimal(1,0)")
    private Boolean loginStatus;

    /**
     * 最近登录时间。
     */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date loginTime;

    /**
     * 最近登出时间。
     */
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date logoutTime;

    /**
     * 实际是一对一关系。不用OneToOne是为了避免n+1问题。
     */
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    UserDetails userDetails;

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public UserUsableType getUserUsableType() {
        return userUsableType;
    }

    public void setUserUsableType(UserUsableType userUsableType) {
        this.userUsableType = userUsableType;
    }

    public Boolean getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(Boolean loginStatus) {
        this.loginStatus = loginStatus;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Date getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(Date logoutTime) {
        this.logoutTime = logoutTime;
    }
}
