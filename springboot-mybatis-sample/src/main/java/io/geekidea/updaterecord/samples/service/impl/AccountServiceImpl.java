/*
 * Copyright 2019-2029 geekidea(https://github.com/geekidea)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.geekidea.updaterecord.samples.service.impl;

import io.geekidea.updaterecord.samples.entity.Account;
import io.geekidea.updaterecord.samples.mapper.AccountMapper;
import io.geekidea.updaterecord.samples.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author geekidea
 * @date 2019-11-15
 **/
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public void pay(Long userId, BigDecimal money) throws Exception {
        // 通过userId获取账户信息
        Account account = accountMapper.getByUserId(userId);
        // 修改之前的余额
        BigDecimal beforeBalance = account.getBalance();
        // 如果扣款金额大于余额，抛出异常
        if (money.compareTo(beforeBalance) == 1) {
            throw new RuntimeException("余额不足，支付失败");
        }
        // 修改之后的余额
        BigDecimal afterBalance = beforeBalance.subtract(money);
        account.setBalance(afterBalance);
        account.setUpdateTime(new Date());
        int result = accountMapper.updateById(account);
        if (result != 1) {
            throw new RuntimeException("支付失败");
        }
    }

}
