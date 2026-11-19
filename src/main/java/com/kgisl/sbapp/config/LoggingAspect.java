package com.kgisl.sbapp.config;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
    Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @AfterThrowing(pointcut = "execution(* com.kgisl.sbapp.controller.*.*(..))", throwing = "excep")
    public void afterThrowing(JoinPoint joinPoint, Throwable excep) {
        System.out.println("After Throwing Method:" + joinPoint.getSignature());
        LOGGER.info("After Throwing Method:" + joinPoint.getSignature());
        LOGGER.error("Exception in method: " + joinPoint.getSignature().getName() + " with arguments: "
                + Arrays.toString(joinPoint.getArgs()));
        LOGGER.error("Exception: ", excep);
    }

}
