package com.raven.cloud.common.web.percolation.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 日志拦截器
 */
public class LoggerInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(LoggerInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("-------------------------------->请求处理<--------------------------------");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("客户端IP: {}", request.getRemoteAddr());
        log.info("请求协议: {}", request.getProtocol());
        log.info("请求URL: {}", request.getRequestURL().toString());
        log.info("请求方法: {}", request.getMethod());
        log.info("响应状态: {}", response.getStatus());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("-------------------------------->处理完毕<--------------------------------");
    }
}
