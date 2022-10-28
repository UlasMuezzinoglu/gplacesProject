package com.ulas.gplacesproject.core;

import com.ulas.gplacesproject.core.annotation.PerformanceTracker;
import com.ulas.gplacesproject.interfaces.repository.other.PerformanceNotifyService;
import com.ulas.gplacesproject.model.entity.PerformanceNotifyEntity;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
@RequiredArgsConstructor
public class PerformanceTrackerAspect {

    private final PerformanceNotifyService performanceNotifyService;

    @Pointcut(value = "execution(* com.ulas.gplacesproject.service.*.*.*(..))")
    private void allServicePointCut() {

    }

    @Around(value = "allServicePointCut()")
    public Object track(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        Method method = null;

        long start = System.currentTimeMillis();

        Object returnedValue = joinPoint.proceed();

        long end = System.currentTimeMillis();

        try {
            method = args.length == 0 ?
                    getMethod(joinPoint, methodName) : getMethod(joinPoint, methodName, args[0].getClass());

            if (method.isAnnotationPresent(PerformanceTracker.class) &&
                    (end - start) > method.getDeclaredAnnotation(PerformanceTracker.class).time()) {
                int time = method.getDeclaredAnnotation(PerformanceTracker.class).time();
                performanceNotifyService.notifyLatedMethod(notifyEntity(methodName, (end - start), time));
            }

        } catch (Exception e) {
            //
        } finally {
            return returnedValue;
        }
    }

    private PerformanceNotifyEntity notifyEntity(String methodName, long executedTime, int definedExecutedTime) {
        PerformanceNotifyEntity performanceNotifyEntity = new PerformanceNotifyEntity();
        performanceNotifyEntity.setMethodName(methodName);
        performanceNotifyEntity.setExecutedTime(executedTime);
        performanceNotifyEntity.setDefinedExecutedTime(definedExecutedTime);
        return performanceNotifyEntity;
    }

    private Method getMethod(ProceedingJoinPoint joinPoint, String methodName) throws NoSuchMethodException {
        return joinPoint.getSourceLocation().getWithinType()
                .getMethod(methodName);
    }

    private Method getMethod(ProceedingJoinPoint joinPoint, String methodName, Class arg) throws NoSuchMethodException {
        return joinPoint.getSourceLocation().getWithinType()
                .getMethod(methodName, arg);
    }
}
