package com.coupang.www.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectConfig {

    @Pointcut("execution(public * org.springframework.data.repository.Repository+.*(..))")
    public void monitor() {}

    @Around("monitor()")
    public Object profile(ProceedingJoinPoint pjp) {
        long start = System.currentTimeMillis();
        
        System.out.println("JVM memory in use = "+ (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()));
        Object output = null;
        
        try {
            output = pjp.proceed();
        } catch (Throwable e) {
        	System.out.println(e.getMessage());
        }
        
        long elapsedTime = System.currentTimeMillis() - start;
        System.out.println(pjp.getTarget()+"."+pjp.getSignature()+": Execution time: " + elapsedTime + " ms. ("+ elapsedTime/60000 + " minutes)");

        return output;
    }
}
