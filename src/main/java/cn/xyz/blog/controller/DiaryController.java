package cn.xyz.blog.controller;

import cn.xyz.blog.entity.Diary;
import cn.xyz.blog.entity.User;
import cn.xyz.blog.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static javax.swing.text.html.CSS.getAttribute;

@Controller
@RequestMapping("/diary")
public class DiaryController {

    @Autowired
    DiaryService diaryService;

    /**
     * 跳转到存储日记页面
     * 如果用户没有登录则跳转到登录界面
     * @return
     */
    @RequestMapping("/Diary")
    public String diary(HttpSession session){
        User user = (User)session.getAttribute("user");
        if(user == null){
            return "user/login";
        }
        return "diary/saveDiary";
    }

    /**
     * 保存日记
     * @param diary
     * @param session
     * @return
     */
    @PostMapping("/saveDiary")
    public String saveDiary(Diary diary, HttpSession session){
       User user = (User)session.getAttribute("user");
     //  SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       diary.setCreateTime(Instant.now());
        Date time = new Date();
        SimpleDateFormat sd = new SimpleDateFormat("yyyy");
        String year = sd.format(time);
        diary.setYear(year);
        diary.setUserId(user.getId());
       diary.setUname(user.getName());
       diaryService.createDiary(diary);
       return "diary";
    }



}
