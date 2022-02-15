package fr.sorbonne.paris.nord.university.api.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.time.LocalDateTime;

@Slf4j
@Aspect
@Component
public class LoggingAspect {

    @Around("@annotation(fr.sorbonne.paris.nord.university.api.annotations.Loggable)")
        public Object doLogging(ProceedingJoinPoint proceedingJoinPoint) throws Throwable
        {
            final String methodName = proceedingJoinPoint.getSignature().getName();
            StopWatch sw = new StopWatch();

            log.info ("Executing {}...", methodName);
            sw.start();
            LocalDateTime start = LocalDateTime.now();
            Object result = proceedingJoinPoint.proceed();
            sw.stop();

            return result;
        }
}
