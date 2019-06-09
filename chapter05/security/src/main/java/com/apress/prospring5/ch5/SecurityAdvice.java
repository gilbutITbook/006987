package com.apress.prospring5.ch5;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class SecurityAdvice implements MethodBeforeAdvice {
    private SecurityManager securityManager;

    public SecurityAdvice() {
        this.securityManager = new SecurityManager();
    }

    @Override
    public void before(Method method, Object[] args, Object target)
            throws Throwable {
        UserInfo user = securityManager.getLoggedOnUser();

        if (user == null) {
            System.out.println("인증되지 않은 사용자입니다");
            throw new SecurityException(
                "메서드를 호출하려면 로그인이 필요합니다: " 
                + method.getName());
        } else if ("John".equals(user.getUserName())) {
            System.out.println("John 사용자로 로그인했습니다 - OKAY!");
        } else {
            System.out.println(user.getUserName() + "사용자로 로그인하였습니다 "
                + " NOT GOOD :(");
            throw new SecurityException("User " + user.getUserName()
                + " 사용자는 메서드에 대한 접근 권한이 없습니다 " + method.getName());
        }
    }
}