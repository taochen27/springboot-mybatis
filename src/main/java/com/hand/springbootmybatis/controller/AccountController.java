package com.hand.springbootmybatis.controller;

import com.hand.springbootmybatis.entity.Account;
import com.hand.springbootmybatis.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @title: AccountController
 * @Author Tao
 * @Date: 2021/7/7 14:51
 * @Version 1.0
 */
@RestController
@ResponseBody
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("getAllAccount")
    public List<Account> getAllAccount() {
        return accountService.getAllAccount();
    }

    @PostMapping("addAccount")
    public void addAccount(@RequestBody Account account) {
        accountService.addAccount(account);
    }

    @DeleteMapping("removeAccount/{id}")
    public void removeAccount(@PathVariable("id") String id) {
        accountService.removeAccount(id);
    }

    @PutMapping("modifyAccount")
    public void modifyAccount(@RequestBody Account account) {
        accountService.modifyAccount(account);
    }

    @GetMapping("getAccountByName/{name}")
    public List<Account> getAccountByName(@PathVariable("name") String name) {
        return accountService.getAccountByName(name);
    }

    @GetMapping("getAccountByMobile/{mobile}")
    public Account getAccountByMobile(@PathVariable("mobile") String mobile) {
        return accountService.getAccountByMobile(mobile);
    }
}
