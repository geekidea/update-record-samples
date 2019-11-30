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

package io.geekidea.updaterecord.samples.controller;

import io.geekidea.updaterecord.annotation.UpdateRecord;
import io.geekidea.updaterecord.samples.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

/**
 * @author geekidea
 * @date 2019-11-15
 **/
@RestController
@RequestMapping("/account")
@UpdateRecord(module = "user")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/pay")
    @UpdateRecord("支付")
    public String pay(@RequestParam Long userId, @RequestParam BigDecimal money) throws Exception{
        accountService.pay(userId,money);
        return "支付成功";
    }

}
