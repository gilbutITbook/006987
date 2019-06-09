package com.apress.prospring5.ch18;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.listener.StepExecutionListenerSupport;
import org.springframework.stereotype.Component;

@Component
public class StepExecutionStatsListener extends StepExecutionListenerSupport {

	public static Logger logger = LoggerFactory.getLogger(StepExecutionStatsListener.class);

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		logger.info("--> " + stepExecution.getStepName() + " 스텝 내에서 " +
				stepExecution.getWriteCount() + "건의 아이템이 기록됨");
		return null;
	}
}
