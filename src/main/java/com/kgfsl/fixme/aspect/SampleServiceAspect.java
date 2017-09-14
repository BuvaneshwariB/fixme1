package com.kgfsl.fixme.aspect;
import java.util.Arrays;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.aspectj.lang.reflect.SourceLocation;

@Aspect
@Component
public class SampleServiceAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(SampleServiceAspect.class);
    
    @Before("execution(* com.kgfsl.fixme..service.*.*(..))")
    public void beforelog(JoinPoint point) {
        // LOGGER.info("BEFORE: "+ point.getSignature().getDeclaringTypeName() + " "+ point.getSignature().getName() + " called...");        
   		LOGGER.info("Entering in Method :  " + point.getSignature().getName());
		LOGGER.info("Class Name :  " + point.getSignature().getDeclaringTypeName());
		LOGGER.info("Arguments :  " + Arrays.toString(point.getArgs()));
		LOGGER.info("Target class : " + point.getTarget().getClass().getName());

    }

    // @After("execution(* com.kgfsl.fixme..service.*.*(..))")
    // public void alterlog(JoinPoint point) {
    //     LOGGER.info("AFTER: "+ point.getSignature().getName() + " called...");        
    // }

}
