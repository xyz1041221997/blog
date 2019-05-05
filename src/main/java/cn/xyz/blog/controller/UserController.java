package cn.xyz.blog.controller;

import cn.xyz.blog.entity.User;
import cn.xyz.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;
    @GetMapping("/login")
    public String login(){
        return "user/login";
    }

    /**
     *执行登录事件
     * @param user
     * @return
     */
    @PostMapping("/doLogin")
    public ModelAndView doLogin(User user,  HttpSession session){
        User user1 =  userService.loginUser(user);
        ModelAndView mv = new ModelAndView();
        session.setAttribute("user",user1);
        if(user1 == null){
           mv.addObject("message","用户名或密码错误");
           mv.setViewName("/user/login");
        }else{
            mv.addObject("user",user1);
            mv.setViewName("redirect:/article");
            userService.addSeeSum(user1.getId());
        }
        return mv;
    }

    /**
     * 跳转到注册界面
     * @return
     */
    @RequestMapping("/regist")
    public String regist(){
        return "user/regist";
    }

    /**
     * 执行注册操作
     * @param user
     * @return
     */
    @RequestMapping("/doRegist")
    public String doRegist(User user){
        Map<String,String> map = new HashMap<String,String>();
        userService.createUser(user);
        map.put("message","注册成功");
        return "redirect:/article";

    }

    /**
     * 查询注册时用户名,账户,邮箱是否已经存在
     * @param username
     * @return
     */
    @PostMapping("/reUserName")
    public Map reUserName(String username){
        Map result = new HashMap();
        result.put("result",userService.reUserName(username));
        System.out.println(result);
        return result;
    }
    @PostMapping("/reName")
    public boolean reName(String name){
        return userService.reName(name);
    }
    @PostMapping("/reMail")
    public Map reMail(String mail){
        Map result = new HashMap();
        result.put("result",userService.reMail(mail));
        System.out.println(result);
        return result;
    }



    @RequestMapping("/outerLogin")
    public String outerLogin(HttpSession session){
        session.invalidate();
        return "redirect:/article";
    }
    @RequestMapping("/userSetting")
    public String userSetting(){
        return "user/updateUser";
    }
}
