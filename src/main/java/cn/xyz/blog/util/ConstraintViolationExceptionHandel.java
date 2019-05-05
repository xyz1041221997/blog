package cn.xyz.blog.util;

import org.thymeleaf.util.StringUtils;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.ArrayList;

public class ConstraintViolationExceptionHandel {


    public static String getMessage(ConstraintViolationException e){
        List<String> list = new ArrayList<>();
        for(ConstraintViolation<?> constraintViolation : e.getConstraintViolations()){
            list.add(constraintViolation.getMessage());
        }
        String message = StringUtils.join(list.toArray() ,";");
        return message;
    }
}
