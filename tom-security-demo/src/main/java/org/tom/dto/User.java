package org.tom.dto;

import com.fasterxml.jackson.annotation.JsonView;
import org.hibernate.validator.constraints.NotBlank;
import org.tom.validator.MyConstraint;

import javax.validation.constraints.Past;
import java.util.Date;

/**
 * 用户dto
 *
 * @author Tom（bibi8086@gmail.com）
 * @date 2018/5/26 下午3:59
 */
public class User {

    public interface UserSimpleView {};
    public interface UserDetailView extends UserSimpleView {};

    private String id;
    @MyConstraint(message = "这是一个测试")
    private String username;
    @NotBlank
    private String password;
    @Past
    private Date birthday;

    @JsonView(UserSimpleView.class)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @JsonView(UserSimpleView.class)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @JsonView(UserDetailView.class)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonView(UserSimpleView.class)
    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
