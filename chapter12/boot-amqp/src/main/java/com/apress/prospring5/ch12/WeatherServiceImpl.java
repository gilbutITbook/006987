package com.apress.prospring5.ch12;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class WeatherServiceImpl {

    private static Logger logger = LoggerFactory.getLogger(WeatherServiceImpl.class);

    @RabbitListener(queues="forecasts")
    public void getForecast(String stateCode) {

        if ("FL".equals(stateCode)) {
            logger.info("더움");
        } else if ("MA".equals(stateCode)) {
            logger.info("추움");
        } else {
            logger.info("지금은 이용할 수 없음");
        }
    }
}
