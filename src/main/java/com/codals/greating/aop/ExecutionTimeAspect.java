package com.codals.greating.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Component
@Aspect
public class ExecutionTimeAspect {
	
	@Around("@annotation(com.codals.greating.aop.ExecutionTime)")
	public Object measure(ProceedingJoinPoint pjp) throws Throwable {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
				
		Object result = pjp.proceed();
		
		stopWatch.stop();
		log.info("[Execution Time] {} - {}ms ", pjp.getSignature().toShortString(), stopWatch.getTotalTimeMillis());
		
		return result;
	}	
	
}