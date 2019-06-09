package com.apress.prospring5.ch10;

import com.apress.prospring5.ch10.config.AppConfig;
import com.apress.prospring5.ch10.obj.Singer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import javax.validation.ConstraintViolation;
import java.util.Set;

public class Jsr349Demo {
    private static Logger logger = LoggerFactory.getLogger(Jsr349Demo.class);


    public static void main(String... args) {

        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        SingerValidationService singerBeanValidationService = ctx.getBean( SingerValidationService.class);

        Singer singer = new Singer();
        singer.setFirstName("J");
        singer.setLastName("Mayer");
        singer.setGenre(null);
        singer.setGender(null);

        validateSinger(singer, singerBeanValidationService);

        ctx.close();
    }

    private static void validateSinger(Singer singer,
            SingerValidationService singerValidationService) {
        Set<ConstraintViolation<Singer>> violations = singerValidationService.validateSinger(singer);
        listViolations(violations);
    }

    private static void listViolations(Set<ConstraintViolation<Singer>> violations) {
        logger.info("유효성 검증 에러 건수: " + violations.size());
        for (ConstraintViolation<Singer> violation : violations) {
            logger.info("유효성 검증 에러. 프로퍼티: " +
                    violation.getPropertyPath()
                    + ", 값: " + violation.getInvalidValue()
                    + ", 에러메시지: " + violation.getMessage());
        }
    }
}
