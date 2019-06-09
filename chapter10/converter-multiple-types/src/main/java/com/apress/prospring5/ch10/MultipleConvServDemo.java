package com.apress.prospring5.ch10;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.convert.ConversionService;

import com.apress.prospring5.ch10.config.AppConfig;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SuppressWarnings("unchecked")
public class MultipleConvServDemo {
    private static Logger logger = LoggerFactory.getLogger(MultipleConvServDemo.class);

    public static void main(String... args) {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        Singer john = ctx.getBean("john", Singer.class);

        logger.info("가수 정보: " + john);

        ConversionService conversionService = ctx.getBean(ConversionService.class);

        AnotherSinger anotherSinger = conversionService.convert(john, AnotherSinger.class);
        logger.info("다른 가수 정보: " + anotherSinger);

        String[] stringArray = conversionService.convert("a,b,c", String[].class);

        logger.info("String 배열: " + stringArray[0] + stringArray[1] + stringArray[2]);

        List<String> listString = new ArrayList<>();
        listString.add("a");
        listString.add("b");
        listString.add("c");

        Set<String> setString = conversionService.convert(listString, HashSet.class);

        setString.forEach(s -> logger.info("Set: " + s));
    }
}
