package org.tom.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.tom.dto.User;
import org.tom.dto.UserQueryCondition;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户控制器
 *
 * @author Tom（bibi8086@gmail.com）
 * @date 2018/5/26 下午3:57
 */
@RestController
@RequestMapping("/users")
public class UserController {

    // 普通参数
    @GetMapping
    @JsonView(User.UserSimpleView.class)
    public List<User> list(@RequestParam(required = false, defaultValue = "tomcat") String username) {

        System.out.println(username);
        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }

    // 组合参数
    @GetMapping("/list2")
    @JsonView(User.UserSimpleView.class)
    public List<User> list2(UserQueryCondition condition) {

        System.out.println(ReflectionToStringBuilder.toString(condition, ToStringStyle.MULTI_LINE_STYLE));
        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }

    // 分页参数
    @GetMapping("/list3")
    @JsonView(User.UserSimpleView.class)
    public List<User> list2(UserQueryCondition condition, @PageableDefault(page = 1, size = 20, sort = "username,asc") Pageable pageable) {

        System.out.println(ReflectionToStringBuilder.toString(condition, ToStringStyle.MULTI_LINE_STYLE));

        System.out.println(ReflectionToStringBuilder.toString(pageable, ToStringStyle.MULTI_LINE_STYLE));
        System.out.println(pageable.getPageNumber());
        System.out.println(pageable.getPageSize());
        System.out.println(pageable.getOffset());
        System.out.println(pageable.getSort());

        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }

    // 常规PathVariable
    //@GetMapping("/users/{id}")
    // 带正则表达式的PathVariable
    @GetMapping("/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User info(@PathVariable String id) {


        //throw new UserNotExistException(id);
        //throw new RuntimeException("user not exist");

        System.out.println("进去info服务");

        User user = new User();
        user.setId(id);
        user.setUsername("tom");
        user.setPassword("123456");
        return user;
    }

    @PostMapping
    public User create(@Valid @RequestBody User user, BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
            bindingResult.getAllErrors().forEach(objectError -> System.out.println(objectError.getDefaultMessage()));
        }

        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getBirthday());

        user.setId("1");
        return user;
    }

    @PutMapping("/{id:\\d+}")
    public User update(@PathVariable String id, @Valid @RequestBody User user, BindingResult bindingResult) {

        if(bindingResult.hasErrors()){
            bindingResult.getAllErrors().forEach(objectError -> {
                FieldError fieldError = (FieldError) objectError;
                String message = fieldError.getField() + " " + fieldError.getDefaultMessage();
                System.out.println(message);
            });
        }

        System.out.println(user.getId());
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(user.getBirthday());

        return user;
    }

    @DeleteMapping("/{id:\\d+}")
    public void delete(@PathVariable String id) {
        System.out.println(id);
    }

    // 方式一
//    @GetMapping("/me")
//    public Object getCurrentUser(){
//        return SecurityContextHolder.getContext().getAuthentication();
//    }

    // 方式二
//    @GetMapping("/me")
//    public Object getCurrentUser(Authentication authentication){
//        return authentication;
//    }

    // 方式三
    @GetMapping("/me")
    public Object getCurrentUser(@AuthenticationPrincipal UserDetails userDetails){
        return userDetails;
    }
}
