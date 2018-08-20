package org.tom.code;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.ServletWebRequest;
import org.tom.security.core.validate.code.ImageCode;
import org.tom.security.core.validate.code.ValidateCodeGenerator;

/**
 * TODO 添加注释
 *
 * @author Tom（bibi8086@gmail.com）
 * @date 2018/6/4 上午1:44
 */
//@Component("imageCodeGenerator")
public class DemoImageCodeGenerator implements ValidateCodeGenerator{

    @Override
    public ImageCode generate(ServletWebRequest request) {
        System.out.println("更高级的图片验证码生成代码");
        return null;
    }
}
