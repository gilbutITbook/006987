package com.apress.prospring5.ch14;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;

public class RuleEngineDemo {
    private static Logger logger = LoggerFactory.getLogger(RuleEngineDemo.class);

    public static void main(String... args) throws Exception {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context.xml");
        // build.gradle 파일의 (*) 로 마킹된 라인에서 "rules"를 삭제한 후
        // 다음 라인의 주석을 풀면 인라인 빈 정의를 사용할 수 있습니다.
        //ctx.load("classpath:spring/app-context-inline.xml");
        ctx.refresh();

        SingerService singerService = ctx.getBean("singerService", SingerService.class);

        Singer singer = new Singer();
        singer.setId(1L);
        singer.setFirstName("John");
        singer.setLastName("Mayer");
        singer.setBirthDate(
                new DateTime(1977, 10, 16, 0, 0, 0, 0));
        singerService.applyRule(singer);
        logger.info("Singer: " + singer);

        System.in.read();

        singerService.applyRule(singer);
        logger.info("Singer: " + singer);

        ctx.close();
    }
}
