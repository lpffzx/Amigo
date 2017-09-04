package com.rabbit.first.controller.aspect;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Aspect
@Component
public class ExceptionHandleAspect {
    @Pointcut("execution(* com.rabbit.first.controller..*.*Controller..*(..))")
    public void performance() {
    }

    @AfterThrowing(throwing = "ex", pointcut = "performance()")
    public void AfterThrowing(JoinPoint jp, Throwable ex) {
        Class declaringType = jp.getSignature().getDeclaringType();
        String methodName = jp.getSignature().getName();
        Logger logger = LogManager.getLogger(declaringType);
        logger.error(MessageFormat.format("Method : {0}, Err : ", methodName), ex);
//        Object args[] = jp.getArgs();
//        for (int i = 0; i < args.length; i++) {
//            if (args[i] instanceof Test) {
//                Test params = (Test) args[i];
//                System.out.println("param name===" + params.getName());
//            }
//        }

    }


}
