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

import io.geekidea.updaterecord.api.entity.UpdateRecordColumnLog;
import io.geekidea.updaterecord.api.entity.UpdateRecordLog;
import io.geekidea.updaterecord.api.entity.UpdateRecordTableLog;
import io.geekidea.updaterecord.api.service.UpdateRecordService;

import java.util.List;
import java.util.Set;

/**
 * @author geekidea
 * @date 2019-11-23
 **/
//@Service
public class XxxServiceImpl implements UpdateRecordService {

    @Override
    public void saveUpdateRecordLog(UpdateRecordLog updateRecordLog) {

    }

    @Override
    public void saveUpdateRecordTableLog(List<UpdateRecordTableLog> updateRecordTableLogs) {

    }

    @Override
    public void saveUpdateRecordColumnLog(Set<UpdateRecordColumnLog> updateRecordColumnLogs) {

    }

    @Override
    public void save(UpdateRecordLog updateRecordLog, List<UpdateRecordTableLog> updateRecordTableLogs, Set<UpdateRecordColumnLog> updateRecordColumnLogs) {

    }
}
