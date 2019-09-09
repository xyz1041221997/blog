package cn.xyz.blog.controller;



import cn.xyz.blog.vo.DoResult;
import cn.xyz.blog.vo.PicResult;
import org.json.JSONObject;
import org.springframework.context.annotation.Description;
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
        // String filePath = "D://StudySpace//blog//src//main//resources//static//temp-rainy//";
        String filePath = "C:/blog/images/title/";
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
        String filename = "/title/" + fileName;
        return filename;
    }

    /**
     * 内容上传图片
     * @param request
     * @param file
     * @return
     * @throws IOException
     */
    @Description(value = "图片上传接口")
    @ResponseBody
    @PostMapping(value = "/uploadFile")
    public PicResult uploadFile(HttpServletRequest request, @Param("file") MultipartFile file,String type) throws IOException{
        PicResult picResult = new PicResult();
        if (file.isEmpty()) {
            picResult.setCode(DoResult.SUCCESS);
            picResult.setMsg("文件为空");
            return picResult;
        }
        String fileName = file.getOriginalFilename();
        // 后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        // 上传后的路径
        String filePath = "C:/blog/images/" + type + "/";
        // 新文件名
        fileName = UUID.randomUUID() + suffixName;
        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            String url = "/" + type + "/" + fileName;
            Map<String,Object> map2 = new HashMap<String,Object>();
            map2.put("src",url);
            map2.put("title",fileName);
            picResult.setMsg("上传成功");
            picResult.setCode(DoResult.SUCCESS);
            picResult.setData(map2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return picResult;
   }
}
