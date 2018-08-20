package org.tom.service.impl;

import org.springframework.stereotype.Service;
import org.tom.service.HelloService;

/**
 * hello服务
 *
 * @author Tom（bibi8086@gmail.com）
 * @date 2018/5/27 下午2:24
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String greeting(String name) {
        System.out.println("greeting");
        return "hello " + name;
    }
}
