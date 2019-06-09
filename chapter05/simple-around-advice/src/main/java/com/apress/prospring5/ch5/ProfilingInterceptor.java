package com.apress.prospring5.ch5;

import java.lang.reflect.Method;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;

public class ProfilingInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        StopWatch sw = new StopWatch();
        sw.start(invocation.getMethod().getName());

        Object returnValue = invocation.proceed();

        sw.stop();
        dumpInfo(invocation, sw.getTotalTimeMillis());
        return returnValue;
    }

    private void dumpInfo(MethodInvocation invocation, long ms) {
        Method m = invocation.getMethod();
        Object target = invocation.getThis();
        Object[] args = invocation.getArguments();

        System.out.println("실행된 메서드 : " + m.getName());
        System.out.println("객체 타입 : " + 
                target.getClass().getName());

        System.out.println("인수 : ");
        for (int x = 0; x < args.length; x++) {
            System.out.print("       > " + args[x]);
        }
        System.out.print("\n");

        System.out.println("실행 시간 : " + ms + " ms");
    }
}
