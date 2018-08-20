package org.tom.web;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * 基础测试类
 *
 * @author Tom（bibi8086@gmail.com）
 * @date 2018/5/27 下午5:59
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BasicTest {

    @Autowired
    private WebApplicationContext context;


    protected MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

}
