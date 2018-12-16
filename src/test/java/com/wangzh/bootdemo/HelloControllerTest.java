package com.wangzh.bootdemo;

import com.wangzh.bootdemo.controller.HelloController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

/**
 * @author wangzhuohui
 * @description 单元测试
 * @since 2018-07-19 17:51
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloControllerTest
{
    private MockMvc mvc;
    
    @Before
    public void setUp(){
        mvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
    }
    
    @Test
    public void getHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().string("Hello Spring Boot!"));
    }
}
