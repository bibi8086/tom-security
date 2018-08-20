package org.tom.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * 异常增强类
 *
 * @author Tom（bibi8086@gmail.com）
 * @date 2018/5/27 下午2:59
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(UserNotExistException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> handlerUserNotExistException(UserNotExistException ex){
        Map<String, Object> map = new HashMap<>();
        map.put("id", ex.getId());
        map.put("message", ex.getMessage());
        return map;
    }
}
