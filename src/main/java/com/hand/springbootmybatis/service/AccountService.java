package com.hand.springbootmybatis.service;

import com.hand.springbootmybatis.entity.Account;

import java.util.List;

/**
 * @title: AccountService
 * @Author Tao
 * @Date: 2021/7/7 14:54
 * @Version 1.0
 */


public interface AccountService {
    List<Account> getAllAccount();

    void addAccount(Account account);

    void removeAccount(String id);

    void modifyAccount(Account account);

    List<Account> getAccountByName(String name);

    Account getAccountByMobile(String mobile);
}
