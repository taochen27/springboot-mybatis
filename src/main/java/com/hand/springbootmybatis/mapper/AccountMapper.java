package com.hand.springbootmybatis.mapper;

import com.hand.springbootmybatis.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * @title: AccountMapper
 * @Author Tao
 * @Date: 2021/7/7 14:52
 * @Version 1.0
 */
@Mapper
public interface AccountMapper {
    List<Account> getAllAccount();

    void addAccount(Account account);

    void removeAccount(String id);

    void modifyAccount(Account account);

    List<Account> getAccountByName(String name);

    Account getAccountByMobile(String mobile);
}
