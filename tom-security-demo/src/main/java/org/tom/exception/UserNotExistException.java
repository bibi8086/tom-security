package org.tom.exception;

/**
 * 自定义用户不存在异常
 *
 * @author Tom（bibi8086@gmail.com）
 * @date 2018/5/27 下午2:57
 */
public class UserNotExistException extends RuntimeException{

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserNotExistException(String id) {
        super("user not exist");
        this.id = id;
    }
}
