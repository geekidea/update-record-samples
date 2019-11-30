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

package io.geekidea.updaterecord.samples.aop;

import io.geekidea.updaterecord.api.entity.UpdateRecordColumnLog;
import io.geekidea.updaterecord.api.entity.UpdateRecordLog;
import io.geekidea.updaterecord.api.entity.UpdateRecordTableLog;
import io.geekidea.updaterecord.core.aop.UpdateRecordAopSupport;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;

/**
 * <pre>
 *     修改记录AOP
 * </pre>
 *
 * @author geekidea
 * @date 2019-11-10
 */
@Slf4j
@Aspect
@Component
public class UpdateRecordAop extends UpdateRecordAopSupport {

    /**
     * 切点
     */
    private static final String POINTCUT = "execution(public * io.geekidea.updaterecord..controller..*.*(..))";

    /**
     * 方法执行之前
     *
     * @param joinPoint
     * @throws Throwable
     */
    @Before(POINTCUT)
    @Override
    protected void doBefore(JoinPoint joinPoint) throws Throwable {
        super.doBeforeHandle(joinPoint);
    }

    /**
     * 方法正常执行并成功返回
     *
     * @param joinPoint
     * @param result
     * @throws Throwable
     */
    @AfterReturning(value = POINTCUT, returning = RESULT)
    @Override
    protected void doAfterReturning(JoinPoint joinPoint, Object result) throws Throwable {
        super.doAfterReturningHandle(joinPoint, result);
    }

    /**
     * 异常处理
     *
     * @param exception
     * @throws Throwable
     */
    @AfterThrowing(value = POINTCUT, throwing = EXCEPTION)
    @Override
    protected void doAfterThrowing(Throwable exception) throws Throwable {
        super.doAfterThrowingHandle(exception);
    }

    @Override
    protected String getToken(HttpServletRequest request) {
        return super.getToken(request);
    }

    @Override
    protected void handleUpdateRecord(UpdateRecordLog updateRecordLog, List<UpdateRecordTableLog> updateRecordTableLogs, Set<UpdateRecordColumnLog> updateRecordColumnLogs) {
        // 需自己完善当前登陆用户ID和用户名称，IP对应的区域，备注信息等
        updateRecordLog.setUserId("1");
        updateRecordLog.setUserName("admin");
        updateRecordLog.setArea("上海");
        updateRecordLog.setRemark("update...");
    }

    @Async
    @Override
    protected void save(UpdateRecordLog updateRecordLog, List<UpdateRecordTableLog> updateRecordTableLogs, Set<UpdateRecordColumnLog> updateRecordColumnLogs) {
        super.save(updateRecordLog, updateRecordTableLogs, updateRecordColumnLogs);
    }
}
