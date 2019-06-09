package com.apress.prospring5.ch5;

import java.lang.reflect.Method;
import org.springframework.aop.AfterReturningAdvice;

import static com.apress.prospring5.ch5.KeyGenerator.WEAK_KEY;

public class WeakKeyCheckAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, 
            Object[] args,Object target) throws Throwable {

        if ((target instanceof KeyGenerator)
                && ("getKey".equals(method.getName()))) {
            long key = ((Long) returnValue).longValue();

            if (key == WEAK_KEY) {
                throw new SecurityException(
                        "키 생성기가 취약 키를 생성했습니다. 키를 다시 생성하기 바랍니다.");
            }
        }
    }
}
