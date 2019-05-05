package cn.xyz.blog.controller;


import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ErrorController {

@ExceptionHandler
    public ModelAndView defaultErrorHandler(HttpServletRequest request, Exception e){
          ModelAndView mv = new ModelAndView();

          mv.addObject("error123","出错了");
          mv.addObject("exception",e);
          System.out.println(e.getMessage());
          mv.addObject("url",request.getRequestURL());
          mv.setViewName("error/500");
          return mv;
    }
}