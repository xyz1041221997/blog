package cn.xyz.blog.controller;



import org.json.JSONObject;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;



import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 上传照片控制层
 */
@Controller
@RequestMapping("/file")
public class Content {

    @PostMapping(value = "/fileUpload")
    public String fileUpload(@RequestParam(value = "file") MultipartFile file) {
        if (file.isEmpty()) {
            System.out.println("文件为空");
        }
        /**
         *   文件名
          */
        String fileName = file.getOriginalFilename();
        // 后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        // 上传后的路径
            String filePath = "D://StudySpace//blog//src//main//resources//static//temp-rainy//";
        // 新文件名
        fileName = UUID.randomUUID() + suffixName;
        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String filename = "/temp-rainy/" + fileName;
        return filename;
    }

    /**
     * 文章内容上传图片
     * @param request
     * @param file
     * @return
     * @throws IOException
     */
    @ResponseBody
@PostMapping(value = "/uploadFile")
public String uploadFile(HttpServletRequest request,@Param("file") MultipartFile file) throws IOException{
    if (file.isEmpty()) {
        System.out.println("文件为空");
    }
    /**
     *   文件名
     */
    String fileName = file.getOriginalFilename();
    // 后缀名
    String suffixName = fileName.substring(fileName.lastIndexOf("."));
    // 上传后的路径
    String filePath = "D:/StudySpace/blog/src/main/resources/static/article/";
    // 新文件名
    fileName = UUID.randomUUID() + suffixName;
    File dest = new File(filePath + fileName);
    if (!dest.getParentFile().exists()) {
        dest.getParentFile().mkdirs();
    }
    try {
        file.transferTo(dest);
    } catch (IOException e) {
        e.printStackTrace();
    }
    String url = "/article/" + fileName;

    Map<String,Object> map = new HashMap<String,Object>();
    Map<String,Object> map2 = new HashMap<String,Object>();
    //0表示成功，1失败
    map.put("code",0);
    //提示消息
    map.put("msg","上传成功");

    map.put("data",map2);
    //图片url
    map2.put("src",url);
    //图片名称，这个会显示在输入框里
    map2.put("title",fileName);
    String result = new JSONObject(map).toString();
    return result;
   }


}
