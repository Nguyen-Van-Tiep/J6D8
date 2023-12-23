package com.j6d8.intercoptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.j6d8.service.CategoryService;

@Component
public class GlobalIntercoptor implements HandlerInterceptor {
    @Autowired
    CategoryService categoryService;

    @Override//(sau khi controller chạy xong thì postha...mới chạy)
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        request.setAttribute("cates", categoryService.findAll());
    }
}
