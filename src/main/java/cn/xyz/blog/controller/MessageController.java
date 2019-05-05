package cn.xyz.blog.controller;

import cn.xyz.blog.entity.Message;
import cn.xyz.blog.entity.User;
import cn.xyz.blog.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.time.Instant;

@Controller
@RequestMapping("/message")
public class MessageController {
    @Autowired
    MessageService messageService;

    /**
     * 保存留言
     * 如果没有登入则跳转到登录页面
     * @param message
     * @return
     */
    @PostMapping("/saveMessage")
    public String createMessage(Message message,HttpSession session){
        User user = (User)session.getAttribute("user");
        if(user == null){
            return "user/login";
        }
        message.setCreateTime(Instant.now());
        message.setUserId(user.getId());
        message.setUserName(user.getName());

        messageService.createMessage(message);
        return "redirect:/message";
    }

}
