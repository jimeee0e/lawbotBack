package bit.project.lawbot.config;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        if (request.getSession().getAttribute("role") != null &&
//                request.getSession().getAttribute("role").equals("USER")){
//            return true;
//        }
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
