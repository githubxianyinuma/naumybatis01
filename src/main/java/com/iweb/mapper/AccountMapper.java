package com.iweb.mapper;

import com.iweb.domain.Account;

import java.util.List;

/**
 * create by Xianyinuma on 2022/10/10 21:09
 * Today is 星期一
 * contact me by email 2015009585@qq.com
 */
public interface AccountMapper {
    /**
     * 查询所有的卡信息（包含用户信息）
     */
    List<Account> selectAllAccount();
}
