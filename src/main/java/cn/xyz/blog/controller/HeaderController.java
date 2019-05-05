package cn.xyz.blog.controller;

import cn.xyz.blog.entity.Article;
import cn.xyz.blog.entity.Diary;
import cn.xyz.blog.entity.Message;
import cn.xyz.blog.service.ArticleService;
import cn.xyz.blog.service.DiaryService;
import cn.xyz.blog.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Controller
public class HeaderController {
    @Autowired
    MessageService messageService;

    @Autowired
    DiaryService diaryService;

    @Autowired
    ArticleService articleService;
    /**
     * 设置欢迎界面  跳到首页
     * @return
     */
    @RequestMapping("/")
    public String index(){
        return "index";
    }

    /**
     * 跳转到首页
     * 寻找浏览 点赞 评论最多的 文章
     * @return
     */
    @RequestMapping("/index")
    public ModelAndView index2(){
        ModelAndView mv = new ModelAndView();
        Article watchArticle = articleService.findMostWatchArticle();

        Article supportArticle = articleService.findMostSupportArticle();

        Article messageArticle = articleService.findMostMessageArticle();

        mv.addObject("watchArticle",watchArticle);
        mv.addObject("supportArticle",supportArticle);
        mv.addObject("messageArticle",messageArticle);
        return mv;
    }
    /**
     * 文章页面
     */
    @RequestMapping("/article")
    public ModelAndView article(){
        ModelAndView mv = new ModelAndView();
        Sort sort = new Sort(Sort.Direction.DESC,"createTime");
        List<Article> articles =  articleService.findAllArticles(sort);
//查询浏览量前7的文章
        List<Article> topArticles = articleService.findTopFive();

        mv.addObject("topArticles",topArticles);
        mv.addObject("articles",articles);
        mv.setViewName("article");
        return mv;
    }

    /**
     * 分页查询所有日记
     * @return
     */
    @RequestMapping("/diary")
    public ModelAndView findAllDiary(@RequestParam(value="start",defaultValue = "0") int start,
             @RequestParam(value = "size",defaultValue = "15") int size){
        start = start < 0 ? 0 :start;
        Sort sort = new Sort(Sort.Direction.DESC,"createTime");
        Pageable pageable = new PageRequest(start,size,sort);

        Page<Diary> page =  diaryService.findAllDiary(pageable);
        ModelAndView mv = new ModelAndView();
        mv.addObject("diarys",page);
        mv.setViewName("/diary");
        return mv;
    }

    /**
     * 分页查询所有留言
     * @param start
     * @param size
     * @return
     */
     @RequestMapping("/message")
    public ModelAndView findAllMessage(@RequestParam(value = "start",defaultValue = "0") int start,
                                 @RequestParam(value = "size",defaultValue = "5") int size){
        start = start < 0 ? 0 : start;
        Sort sort = new Sort(Sort.Direction.ASC,"createTime");
        Pageable page = new PageRequest(start,size,sort);
        Page<Message> messages = messageService.findAllMessage(page);
        ModelAndView mv = new ModelAndView();
        mv.addObject("messages",messages);
        mv.setViewName("/message");
        return mv;
    }
//    public
}
