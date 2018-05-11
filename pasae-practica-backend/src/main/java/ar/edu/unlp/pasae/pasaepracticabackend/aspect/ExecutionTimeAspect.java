package ar.edu.unlp.pasae.pasaepracticabackend.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class ExecutionTimeAspect {
	
	private static final Logger logger = LoggerFactory.getLogger(ExecutionTimeAspect.class);

	public ExecutionTimeAspect() {
		// TODO Auto-generated constructor stub
	}
	
	@Around(value = "execution(* ar.edu.unlp.pasae.pasaepracticabackend.service.*.*(..))")
	public Object time(final ProceedingJoinPoint joinPoint) throws Throwable {
		
		Long inicio = System.currentTimeMillis();
		
		logger.info("Se va a ejecutar el servicio {}", joinPoint);
		
		Object proceed = joinPoint.proceed();
		
		Long time = inicio - System.currentTimeMillis();
	
		
		logger.info("Se ejecutó el servicio {} y su ejecucion tardo " + time + " milisegundos", joinPoint);
		
		return proceed;

	}


}
