package cn.xyz.blog.controller;

import cn.xyz.blog.entity.Comments;
import cn.xyz.blog.entity.User;
import cn.xyz.blog.service.ArticleService;
import cn.xyz.blog.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.time.Instant;

@Controller
@RequestMapping("/Comment")
public class CommentsController {
    @Autowired
    CommentsService commentsService;
    @Autowired
    ArticleService articleService;
    @PostMapping("/createComment")
    public String CreateComment(Comments comment, String targetUserId, HttpSession session){
        User user = (User)session.getAttribute("user");
        if(user==null){
            return "user/login";
        }

        comment.setUserName(user.getName());
        comment.setUserId(user.getId());
        comment.setCreateTime(Instant.now());
        commentsService.createComments(comment);
        articleService.addMessageSum(comment.getArticleId());
        String url = "redirect:/article/findOne/?id=" + comment.getArticleId();
        return url;

    }
}
