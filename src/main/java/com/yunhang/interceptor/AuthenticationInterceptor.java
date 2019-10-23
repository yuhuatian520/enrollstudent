package com.yunhang.interceptor;

import com.yunhang.annotation.PassToken;
import com.yunhang.annotation.UserLoginToken;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 王耀
 * \* Date: 2019/10/22
 * \* Time: 17:51
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 * @author Administrator
 */
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取请求头
        String token = request.getHeader("token");
            if (!(handler instanceof HandlerMethod)){
                return true;
            }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
            if (method.isAnnotationPresent(PassToken.class)){
                PassToken passToken = method.getAnnotation(PassToken.class);
                    if (passToken.require()){
                        return true;
                    }
            }
            if (method.isAnnotationPresent(UserLoginToken.class)){
                UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);

            }


        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
