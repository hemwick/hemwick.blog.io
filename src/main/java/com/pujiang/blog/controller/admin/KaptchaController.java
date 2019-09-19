package com.pujiang.blog.controller.admin;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.pujiang.blog.util.ResBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.util.Map;

@Controller
public class KaptchaController {
    @Autowired
    private Producer producer;

    @RequestMapping("kaptcha.jpg")
    public void getKaptcha(HttpServletRequest request, HttpServletResponse response)throws Exception{
        response.setDateHeader("Expires", 0);
        // Set standard HTTP/1.1 no-cache headers.
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        // Set IE extended HTTP/1.1 no-cache headers (use addHeader).
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        // Set standard HTTP/1.0 no-cache header.
        response.setHeader("Pragma", "no-cache");
        // return a jpeg
        response.setContentType("image/jpeg");
        // create the text for the image
        String capText = producer.createText();/*生成验证码的文字内容*/
        // store the text in the session
        /*把值放入session作用域*/
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
        // create the image with the text
        BufferedImage bi = producer.createImage(capText);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(bi, "jpg", out);
        out.flush();
        out.close();
    }

    @RequestMapping("/verify")
    @ResponseBody
    public ResBean verify(String verify, HttpSession session){
        /*获取session作用域中存在的验证码字符串*/
        String sessionText=session.getAttribute(Constants.KAPTCHA_SESSION_KEY).toString();
        /*全部转换为大写*/
        sessionText=sessionText.toUpperCase();
        verify=verify.toUpperCase();
     /*   if (sessionText.equals(verify)){
            return new ResBean(true);
        }return new ResBean(false);*/
        return new ResBean(sessionText.equals(verify));
    }


}
