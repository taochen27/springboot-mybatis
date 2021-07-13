package com.hand.springbootmybatis.service.impl;

import com.hand.springbootmybatis.entity.Account;
import com.hand.springbootmybatis.mapper.AccountMapper;
import com.hand.springbootmybatis.service.AccountService;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @title: AccountServiceImpl
 * @Author Tao
 * @Date: 2021/7/7 14:55
 * @Version 1.0
 */
/**
 * RabbitTemplate: 给RabbitMQ发送和接受消息
 * AmqpAdmin： RabbitMQ系统管理功能组件；
 * AmqpAdmin： 创建和删除Query，Exchange，Binding
 * @EnableRabbit + @RabbitListener 监听消息队列的内容
 */
@Service
@CacheConfig(cacheNames = "accounts")
public class AccountServiceImpl implements AccountService {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    private AccountMapper accountMapper;

    @Override
    @Cacheable("allAccounts")
    public List<Account> getAllAccount() {
        List<Account> allAccounts = accountMapper.getAllAccount();
        return allAccounts;
    }

    @Override
    public void addAccount(Account account) {
        rabbitTemplate.convertAndSend("amqpadmin.exchange", "amqp.hand", account);
        Object o = rabbitTemplate.receiveAndConvert("amqpadmin.queue");
        System.out.println(o);
        accountMapper.addAccount(account);
    }

    @Override
    public void removeAccount(String id) {
        accountMapper.removeAccount(id);
    }

    @Override
    public void modifyAccount(Account account) {
        accountMapper.modifyAccount(account);
    }

    @Override
    @Cacheable(key = "#name")
    public List<Account> getAccountByName(String name) {
        return accountMapper.getAccountByName(name);
    }

    @Override
    @Cacheable(key = "#mobile")
    public Account getAccountByMobile(String mobile) {
        return accountMapper.getAccountByMobile(mobile);
    }
}
