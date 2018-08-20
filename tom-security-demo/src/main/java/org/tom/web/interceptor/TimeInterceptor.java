package org.tom.web.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * 时间拦截器
 *
 * @author Tom（bibi8086@gmail.com）
 * @date 2018/5/27 下午3:22
 */
@Component
public class TimeInterceptor implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        // 控制器方法调用之前被调用
        System.out.println("timeInterceptor preHandle");
        System.out.println("timeInterceptor preHandle " + ((HandlerMethod)handler).getBean().getClass().getName());
        System.out.println("timeInterceptor preHandle " + ((HandlerMethod)handler).getMethod().getName());
        httpServletRequest.setAttribute("startTime", new Date().getTime());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, ModelAndView modelAndView) throws Exception {
        // 控制器方法调用之后被调用，如果控制器方法中抛出异常，该方法不会被调用
        System.out.println("timeInterceptor postHandle");
        long startTime = (long) httpServletRequest.getAttribute("startTime");
        System.out.println("timeInterceptor time: " + (new Date().getTime() - startTime));
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, Exception ex) throws Exception {
        // 控制器方法调用之后始终都会被调用，注意如果使用了ControllerAdvice处理了的异常这里将不会获取到异常信息
        System.out.println("timeInterceptor afterCompletion");
        long startTime = (long) httpServletRequest.getAttribute("startTime");
        System.out.println("timeInterceptor after time: " + (new Date().getTime() - startTime));
        System.out.println("timeInterceptor ex is: " + ex);
    }
}
