package org.tom.security.core.validate.code;

import org.springframework.web.context.request.ServletWebRequest;

/**
 * TODO 添加注释
 *
 * @author Tom（bibi8086@gmail.com）
 * @date 2018/6/4 上午1:35
 */
public interface ValidateCodeGenerator {

    ImageCode generate(ServletWebRequest request);
}
