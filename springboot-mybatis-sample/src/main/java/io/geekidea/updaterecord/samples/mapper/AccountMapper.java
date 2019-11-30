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

package io.geekidea.updaterecord.samples.mapper;

import io.geekidea.updaterecord.samples.entity.Account;
import org.apache.ibatis.annotations.Param;

/**
 * @author geekidea
 * @date 2019-11-15
 **/
public interface AccountMapper {

    /**
     * 通过用户ID获取账户信息
     *
     * @param userId
     * @return
     */
    Account getByUserId(@Param("userId") Long userId);

    /**
     * 通过用户ID修改账户信息
     * 参数为实体对象
     *
     * @param account
     * @return
     */
    int updateById(Account account);

}
