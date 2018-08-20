package org.tom.web.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.util.Date;

/**
 * 时间过滤器
 *
 * @author Tom（bibi8086@gmail.com）
 * @date 2018/5/27 下午3:06
 */
//@Component 可以在WebConfig中配置
public class TimeFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("timeFilter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("timeFilter start");
        long start = new Date().getTime();
        filterChain.doFilter(servletRequest, servletResponse);
        long end = new Date().getTime();
        System.out.println("timeFilter time: " + (end - start));
        System.out.println("timeFilter finish");
    }

    @Override
    public void destroy() {
        System.out.println("timeFilter destroy");
    }
}
