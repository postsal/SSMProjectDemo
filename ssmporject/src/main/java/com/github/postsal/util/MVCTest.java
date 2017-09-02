package com.github.postsal.util;

import com.github.pagehelper.PageInfo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

/**
 * Created by hujian on 2017/9/2.
 */
@RunWith(SpringJUnit4ClassRunner.class) //指定使用spring的单元测试模块
@WebAppConfiguration    //使WebApplicationContext可以注入
@ContextConfiguration(locations = {"classpath:Spring.xml", "classpath:SpringMVC.xml", "classpath:mybatis-config.xml"})
public class MVCTest {
    @Autowired
    private WebApplicationContext context;
    private MockMvc mockMvc;

    @Before
    public void initMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void testPage() throws Exception {
        //模拟请求拿到返回值
        MvcResult result = mockMvc.perform(get("/emps").param("pageNumber", "1"))
                .andReturn();//获取请求的返回值
        MockHttpServletRequest request = result.getRequest();
        System.out.println(request.getAttributeNames().nextElement());
        PageInfo pageInfo= (PageInfo) request.getAttribute("pageInfo");
        System.out.println("当前页码："+pageInfo);/*
        System.out.println("总页数："+pageInfo.getPages());
        System.out.println("总记录数："+pageInfo.getPageNum());
*/
    }
}
