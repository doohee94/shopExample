package com.example.demo.common;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class Interceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //클라이언트에서 컨트롤러로 요청할 떄 가로채는 것. 컨트롤러가 호출되기 전에 실행되는 메소드
        System.out.println("---------------------안뇽");
        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //컨트롤러에스 클라이언트로 요청할 때 가로채는 것. 컨트롤러가 호출되고 난 후 실행되는 메소드
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //컨트롤러의 처리가 끝나고 화면처리까지 모두 끝나면 실행되는 메소드
        super.afterCompletion(request, response, handler, ex);
    }
}
