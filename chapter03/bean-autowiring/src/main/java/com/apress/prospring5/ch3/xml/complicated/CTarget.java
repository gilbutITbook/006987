package com.apress.prospring5.ch3.xml.complicated;

import com.apress.prospring5.ch3.xml.Bar;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Created by iuliana.cosmina on 2/24/17.
 */
public class CTarget {

	private Foo fooOne;
	private Foo fooTwo;
	private Bar bar;

	public CTarget() {
	}

	public CTarget(Foo foo) {
		System.out.println("Target(Foo) 호출");
	}

	public CTarget(com.apress.prospring5.ch3.xml.Foo foo, Bar bar) {
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
		//using primary
		ctx.load("classpath:spring/app-context-04.xml");

		//using qualifier
		//ctx.load("classpath:spring/app-context-05.xml");
		ctx.refresh();
		System.out.println("\nbyType을 사용:\n");
		CTarget t = (CTarget) ctx.getBean("targetByType");
		ctx.close();
	}
}