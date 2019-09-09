package cn.xyz.blog.controller;

import cn.xyz.blog.entity.Article;
import cn.xyz.blog.entity.Diary;
import cn.xyz.blog.entity.Message;
import cn.xyz.blog.service.ArticleService;
import cn.xyz.blog.service.DiaryService;
import cn.xyz.blog.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Description;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Description("查询所有日记")
    @RequestMapping("/diary")
    @ResponseBody
    public ModelAndView findAllDiary(){
        List<String> years = diaryService.findYears();
        List<Map> datas = new ArrayList<Map>();
        for (String year: years) {
           List<Diary> diarys =  diaryService.findDiaryByYear(year);
           Map<String,Object> map = new HashMap<String,Object>();
           map.put("year",year);
           map.put("data",diarys);
            System.out.println("你好");
           datas.add(map);
        }
        ModelAndView mv = new ModelAndView();
        mv.addObject("datas",datas);
        mv.setViewName("/diary");
        return mv;
    }

//    @Description("查询所有日记")
//    @RequestMapping("/diary2")
//    @ResponseBody
//    public List<Map> findAllDiarys(){
//        List<String> years = diaryService.findYears();
//        List<Map> datas = new ArrayList<Map>();
//        for (String year: years) {
//            List<Diary> diarys =  diaryService.findDiaryByYear(year);
//            Map<String,Object> map = new HashMap<String,Object>();
//            map.put("year",year);
//            map.put("data",diarys);
//            datas.add(map);
//        }
//      return datas;
//    }
@RequestMapping("/diary2")
public String diary2(){
    return "diary2";
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
