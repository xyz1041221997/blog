package cn.xyz.blog.controller;

import cn.xyz.blog.entity.Article;
import cn.xyz.blog.entity.Comments;
import cn.xyz.blog.entity.User;
import cn.xyz.blog.service.ArticleService;
import cn.xyz.blog.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.time.Instant;
import java.util.List;

@Controller
@RequestMapping("/article")
public class ArticleController {
   @Autowired
    ArticleService articleService;
   @Autowired
    CommentsService commentsService;

   @Autowired
   Content content;

//    HttpSession session;
//    User user = (User)session.getAttribute("user");

    /**
     * 存储文章
     * @param article
     * @return
     */
    @PostMapping("/createArticle")
    public String createArticle(Article article, HttpSession session){
        User user = (User)session.getAttribute("user");
        if(user==null){
            return "user/login";
        }
        article.setMessageSum(0L);
        article.setSupportSum(0L);
        article.setWatchSum(0L);
        article.setUserName(user.getName());
        article.setUserId(user.getId());
        article.setCreateTime(Instant.now());

        articleService.createArticle(article);
        return "redirect:/article";
   }
   @RequestMapping("/article")
   public String toSaveArticle(Article article){
        return "user/doArticle";
   }

    /**
     * 寻找一篇文章 并且观众数+1
     * @param id
     * @return
     */
   @RequestMapping("/findOne")
    public ModelAndView findOne(Long id){
       Article article = articleService.findOne(id);
       articleService.addWatchSum(id);

       //查找评论
       List<Comments> comments = commentsService.findComments(id);
       ModelAndView mv = new ModelAndView();
       mv.addObject("comments",comments);
       mv.addObject("article",article);
       mv.setViewName("read");
       return mv;
   }
   @RequestMapping("/read")
   public String getRead(){
        return "read";
   }

}
