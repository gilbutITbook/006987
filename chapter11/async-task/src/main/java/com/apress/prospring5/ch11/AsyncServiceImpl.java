package com.apress.prospring5.ch11;

import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

@Service("asyncService")
public class AsyncServiceImpl implements AsyncService {
    final Logger logger = LoggerFactory.getLogger(AsyncServiceImpl.class);

    @Async
    @Override
    public void asyncTask() {
        logger.info("비동기 태스크 실행 시작");

        try {
            Thread.sleep(10000);
        } catch (Exception ex) {
            logger.error("태스크 인터럽트", ex);
        }

        logger.info("비동기 태스크 실행 완료");
    }

    @Async
    @Override
    public Future<String> asyncWithReturn(String name) {
        logger.info(name + "을 반환하는 비동기 태스크 실행 시작");

        try {
            Thread.sleep(5000);
        } catch (Exception ex) {
            logger.error("태스크 인터럽트", ex);
        }

        logger.info(name + "을 반환하는 비동기 태스크 실행 완료");

        return new AsyncResult<>("Hello: " + name);
    }
}
