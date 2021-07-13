package com.hand.springbootmybatis.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @title: Account
 * @Author Tao
 * @Date: 2021/7/7 14:52
 * @Version 1.0
 */
@Data
public class Account implements Serializable {
    private String id;

    private String name;

    private String mobile;

    private String remark;
}
