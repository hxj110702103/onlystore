package com.han.onlystore.backoffice.aspect;

import ch.ralscha.extdirectspring.bean.ExtDirectFormPostResult;
import ch.ralscha.extdirectspring.bean.ExtDirectResponse;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreResult;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Amy on 2017/2/21.
 */
@Aspect
@Component
public class ActionAspect {

    @Around("execution(public ch.ralscha.extdirectspring.bean.ExtDirectStoreResult com.han.onlystore.backoffice.action..*.*(..))")
    public Object method1(ProceedingJoinPoint pjp) throws Throwable {
        try {
            return pjp.proceed();
        } catch (Exception ex) {
            ExtDirectStoreResult result = new ExtDirectStoreResult();
            result.setSuccess(Boolean.FALSE);
            result.setMessage(ex.getMessage());
            return result;
        }
    }

    @Around("execution(public ch.ralscha.extdirectspring.bean.ExtDirectResponse com.han.onlystore.backoffice.action..*.*(..))")
    public Object dosomething2(ProceedingJoinPoint pjp) throws Throwable{
        try {
            return pjp.proceed();
        } catch (Exception ex) {
            ExtDirectResponse result = new ExtDirectResponse();
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("success", Boolean.FALSE);
            map.put("message", ex.getMessage());
            result.setResult(map);
            result.setMessage(ex.getMessage());
            return result;
        }
    }

    @Around("execution(public ch.ralscha.extdirectspring.bean.ExtDirectFormPostResult com.han.onlystore.backoffice.action..*.*(..))")
    public Object dosomething3(ProceedingJoinPoint pjp) throws Throwable{
        try {
            return pjp.proceed();
        } catch (Exception ex) {
            ExtDirectFormPostResult result=new ExtDirectFormPostResult();
            result.setSuccess(false);
            result.addError("message",ex.getMessage());
            return result;
        }
    }
}
