package com.yy.emp.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable{
    private Integer id;

    private String code;

    private String name;

    private String salt;

    private String password;

    private Integer userType;

    private String isActive;

    private Integer createUserId;

    private Date createTime;

    private Integer updateUserId;

    private Date updateTime;

    private String token;

    private String mac;
}