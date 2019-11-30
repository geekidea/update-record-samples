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

create table if not exists tb_account
(
    id bigint auto_increment comment '主键'
        primary key,
    user_id bigint not null comment '用户ID',
    balance decimal(10,2) default 0.00 not null comment '余额',
    version int default 0 not null comment '版本',
    create_time timestamp default CURRENT_TIMESTAMP null comment '创建时间',
    update_time timestamp null comment '修改时间'
)
    comment '账户信息';

