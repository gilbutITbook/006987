package com.apress.prospring5.ch3.xml;

import org.springframework.context.support.GenericXmlApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionInjection {

	private Map<String, Object> map;
	private Properties props;
	private Set set;
	private List list;

	public static void main(String... args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:spring/app-context-xml.xml");
		ctx.refresh();

		CollectionInjection instance = (CollectionInjection) ctx.getBean("injectCollection");
		instance.displayInfo();

		ctx.close();
	}

	public void displayInfo() {
		System.out.println("Map 내용:\n");
		map.entrySet().stream().forEach(e -> System.out.println("키: " + e.getKey() + " - 값: " + e.getValue()));

		System.out.println("\nProperties 내용:\n");
		props.entrySet().stream().forEach(e -> System.out.println("키: " + e.getKey() + " - 값: " + e.getValue()));

		System.out.println("\nSet 내용:\n");
		set.forEach(obj -> System.out.println("값: " + obj));

		System.out.println("\nList 내용:\n");
		list.forEach(obj -> System.out.println("값:  " + obj));
	}

	public void setList(List list) {
		this.list = list;
	}

	public void setSet(Set set) {
		this.set = set;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public void setProps(Properties props) {
		this.props = props;
	}
}
