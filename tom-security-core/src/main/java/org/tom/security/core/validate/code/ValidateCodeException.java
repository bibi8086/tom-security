package org.tom.security.core.validate.code;

import org.springframework.security.core.AuthenticationException;

/**
 * TODO 添加注释
 *
 * @author Tom（bibi8086@gmail.com）
 * @date 2018/6/4 上午12:19
 */
public class ValidateCodeException extends AuthenticationException{

    public ValidateCodeException(String msg) {
        super(msg);
    }
}
