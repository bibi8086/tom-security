package org.tom.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 时间切片
 *
 * @author Tom（bibi8086@gmail.com）
 * @date 2018/5/27 下午5:22
 */
@Aspect
@Component
public class TimeAspect {

    @Around("execution(* org.tom.web.controller.UserController.*(..))")
    public Object handlerControllerMethod(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("timeAspect start");
        Object[] args = pjp.getArgs();
        for (Object arg : args){
            System.out.println("timeAspect arg is " + arg);
        }

        long start = new Date().getTime();

        Object object = pjp.proceed();

        long end = new Date().getTime();
        System.out.println("timeAspect time: " + (end - start));
        System.out.println("timeAspect end");
        return object;
    }

}
