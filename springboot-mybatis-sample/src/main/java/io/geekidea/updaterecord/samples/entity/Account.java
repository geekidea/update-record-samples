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

package io.geekidea.updaterecord.samples.entity;

import io.geekidea.updaterecord.annotation.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 账户
 *
 * @author geekidea
 * @date 2019-11-15
 **/
@Data
@Accessors(chain = true)
@UpdateRecordTable(name = "tb_account", value = "账户")
public class Account implements Serializable {

    private static final long serialVersionUID = -2852768164693452983L;

    @UpdateRecordId
    private Long id;

    /**
     * 用户ID
     */
    @UpdateRecordColumn(name = "user_id",value = "用户ID")
    private Long userId;

    /**
     * 余额
     */
    @UpdateRecordColumn("余额")
    private BigDecimal balance;

    /**
     * 用于记录版本
     */
    @UpdateRecordVersion
    private Integer version;

    @UpdateRecordColumn
    private Date createTime;

    private Date updateTime;

}
