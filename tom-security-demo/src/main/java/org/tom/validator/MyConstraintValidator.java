package org.tom.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.tom.service.HelloService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 自定义校验实现
 *
 * @author Tom（bibi8086@gmail.com）
 * @date 2018/5/27 下午2:16
 */

public class MyConstraintValidator implements ConstraintValidator<MyConstraint, Object>{

    @Autowired
    private HelloService helloService;

    @Override
    public void initialize(MyConstraint myConstraint) {
        System.out.println("my validator init");
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
        helloService.greeting("tom");
        System.out.println(value);
        return false;
    }
}
