package com.apress.prospring5.ch3.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Target {
    private Foo fooOne;
    private Foo fooTwo;
    private Bar bar;

    public Target() {
    }
    
    public Target(Foo foo) {
        System.out.println("Target(Foo) 호출");
    }
    
    public Target(Foo foo, Bar bar) {
        System.out.println("Target(Foo, Bar) 호출");
    }
    
    public void setFooOne(Foo fooOne) {
        this.fooOne = fooOne;
        System.out.println("프로퍼티 fooOne 설정");
    }
    
    public void setFooTwo(Foo foo) {
        this.fooTwo = foo;
        System.out.println("프로퍼티 fooTwo 설정");
    }

    public void setBar(Bar bar) {
        this.bar = bar;
        System.out.println("프로퍼티 bar 설정");
    }

    public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-03.xml");
        ctx.refresh();

        Target t = null;
        
        System.out.println("byName을 사용:\n");
        t = (Target) ctx.getBean("targetByName");
        
        System.out.println("\nbyType을 사용:\n");
        t = (Target) ctx.getBean("targetByType");
        
        System.out.println("\nconstructor를 사용:\n");
        t = (Target) ctx.getBean("targetConstructor");

        ctx.close();
        
    }
}
