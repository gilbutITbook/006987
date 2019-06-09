package com.apress.prospring5.ch3;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HierarchicalAppContextUsage {

	public static void main(String... args) {
		GenericXmlApplicationContext parent = new GenericXmlApplicationContext();
		parent.load("classpath:spring/parent-context.xml");
		parent.refresh();

		GenericXmlApplicationContext child = new GenericXmlApplicationContext();
		child.load("classpath:spring/child-context.xml");
		child.setParent(parent);
		child.refresh();

		Song song1 = (Song) child.getBean("song1");
		Song song2 = (Song) child.getBean("song2");
		Song song3 = (Song) child.getBean("song3");

		System.out.println("parent 컨텍스트로부터: " + song1.getTitle());
		System.out.println("child 컨텍스트로부터: " + song2.getTitle());
		System.out.println("parent 컨텍스트로부터: " + song3.getTitle());

		child.close();
		parent.close();
	}
}
