package com.apress.prospring5.ch14

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component("ruleEngine")
class RuleEngineImpl implements RuleEngine {
    Logger logger = LoggerFactory.getLogger(RuleEngineImpl.class);

    void run(Rule rule, Object object) {
        logger.info "규칙 실행"

        def exit=false

        rule.parameters.each{ArrayList params ->
            def paramIndex=0
            def success=true

            if(!exit){
                rule.conditions.each{
                    logger.info "조건 파라미터 번호: " + paramIndex
                    success = success && it(object,params[paramIndex])
                    logger.info "조건 성공: " + success
                    paramIndex++
                }

                if(success && !exit){
                    rule.actions.each{
                        logger.info "액션 파라미터 번호: " + paramIndex
                        it(object,params[paramIndex])
                        paramIndex++
                    }
                    if (rule.singlehit){
                        exit=true
                    }
                }
            }
        }
    }
}
