package com.github.postsal.util;

import com.github.postsal.dao.DepartmentMapper;
import com.github.postsal.dao.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by hujian on 2017/9/1.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:Spring.xml","classpath:SpringMVC.xml","classpath:mybatis-config.xml"})
public class springTest {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Test
    public void test(){
        System.out.println(employeeMapper.selectByPrimaryKeyWithDept(1).getdId());
    }

}
