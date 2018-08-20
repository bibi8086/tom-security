package org.tom.web.controller;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.tom.web.BasicTest;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

/**
 * 用户控制层测试
 *
 * @author Tom（bibi8086@gmail.com）
 * @date 2018/5/26 下午3:46
 */
public class UserControllerTest extends BasicTest {

    @Test
    public void whenListSuccess() throws Exception {
        String result = mockMvc.perform(MockMvcRequestBuilders.get("/users")
                .param("username", "tom")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3))
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }

    @Test
    public void whenList2Success() throws Exception {
        String result = mockMvc.perform(MockMvcRequestBuilders.get("/users/list2")
                .param("username", "tom")
                .param("age", "18")
                .param("ageTo", "60")
                .param("xxx", "yyy")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3))
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }

    @Test
    public void whenList3Success() throws Exception {
        String result = mockMvc.perform(MockMvcRequestBuilders.get("/users/list3")
                .param("username", "tom")
                .param("age", "18")
                .param("ageTo", "60")
                .param("xxx", "yyy")
                .param("page", "2")
                .param("size", "10")
                .param("offset", "2")
                .param("sort", "age,desc")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3))
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }

    @Test
    public void whenInfoSuccess() throws Exception {
        String result = mockMvc.perform(MockMvcRequestBuilders.get("/users/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("tom"))
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }

    @Test
    public void whenInfoFail() throws Exception {
        String result = mockMvc.perform(MockMvcRequestBuilders.get("/users/a")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError())
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }

    @Test
    public void whenCreateSuccess() throws Exception {

        Date date = new Date();
        System.out.println(date.getTime());

        String content = "{\"username\":\"tom\",\"password\":null,\"birthday\":" + date.getTime() + "}";
        String result = mockMvc.perform(MockMvcRequestBuilders.post("/users")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(content))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("1"))
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }

    @Test
    public void whenUpdateSuccess() throws Exception {

        Date date = new Date(LocalDateTime.now().plusYears(1).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli());
        System.out.println(date.getTime());

        String content = "{\"id\":\"1\",\"username\":\"tom\",\"password\":null,\"birthday\":" + date.getTime() + "}";
        String result = mockMvc.perform(MockMvcRequestBuilders.put("/users/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(content))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value("1"))
                .andReturn().getResponse().getContentAsString();
        System.out.println(result);
    }

    @Test
    public void whenDeleteSuccess() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/users/1")
                .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
