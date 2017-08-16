package dev.paie.config.aspect;

import java.time.LocalDateTime;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import dev.paie.entite.Performance;
import dev.paie.repository.PerformanceRepository;

@Configuration
@Aspect
public class ControllerPerformanceAspect {
	private static final Logger LOGGER = LoggerFactory.getLogger(ControllerPerformanceAspect.class);
	
	@Autowired
	PerformanceRepository performanceRepo;
	
	@Around("execution(* dev.paie.web.controller.*.*(..))")
	public Object logPerf(ProceedingJoinPoint joinPoint) throws Throwable {

		
		
		String nameMethodeCalled = joinPoint.getSignature().getName();
		
		LOGGER.debug("logAround() is running!");
		LOGGER.debug("méthode appelée : " + nameMethodeCalled);
		
		Performance performance = new Performance();
		performance.setNomService(nameMethodeCalled);
		long start = System.currentTimeMillis();
		
		Object valeurRetournee = joinPoint.proceed(); 
		
		long end = System.currentTimeMillis();
		long timeExecution = end - start;
		performance.setTempsExecution(timeExecution);
		performance.setDateHeure(LocalDateTime.now());
		if(performance!=null){
			performanceRepo.save(performance);
		}
		
		LOGGER.debug("******");
		return valeurRetournee;
	}
	
	
}