package org.tom.security.core.validate.code;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;
import org.tom.security.core.properties.SecurityProperties;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 图片验证码控制器
 *
 * @author Tom（bibi8086@gmail.com）
 * @date 2018/6/3 下午11:41
 */
@RestController
public class ValidateCodeController {

    private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

    @Autowired
    private ValidateCodeGenerator imageCodeGenerator;


    @GetMapping("/code/image")
    public void createCode(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // 1. 根据随机数生成图片
        ImageCode imageCode = imageCodeGenerator.generate(new ServletWebRequest(request));

        // 2. 将随机数存到Session中
        sessionStrategy.setAttribute(new ServletWebRequest(request), ImageCode.SESSION_KEY, imageCode);

        // 3. 将生成的图片写到接口的响应中
        ImageIO.write(imageCode.getImage(), "JPEG", response.getOutputStream());

    }
}
