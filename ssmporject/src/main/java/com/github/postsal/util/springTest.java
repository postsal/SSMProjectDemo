package com.github.postsal.util;

import com.github.pagehelper.PageInfo;
import com.github.postsal.bean.Department;
import com.github.postsal.bean.Employee;
import com.github.postsal.dao.DepartmentMapper;
import com.github.postsal.dao.EmployeeMapper;
import com.github.postsal.service.EmployeeService;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.UUID;

/**
 * Created by hujian on 2017/9/1.
 */
@RunWith(SpringJUnit4ClassRunner.class) //指定使用spring的单元测试模块
@ContextConfiguration(locations = {"classpath:Spring.xml","classpath:SpringMVC.xml","classpath:mybatis-config.xml"})
public class springTest {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private DepartmentMapper departmentMapper;
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private SqlSession sqlSession;

    @Test
    public void test(){
        System.out.println(employeeMapper.selectByPrimaryKeyWithDept(1).getdId());
    }

    @Test
    public void getAllTest(){
        /*departmentMapper.insertSelective(new Department(null,"测试部"));
        departmentMapper.insertSelective(new Department(null,"运维部"));*/

        //employeeMapper.insertSelective(new Employee("jack","jack@qq.com","1",1));

        /*EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        for (int i = 0; i < 1000; i++) {
            String uid = UUID.randomUUID().toString().substring(0,5)+i;
            mapper.insertSelective(new Employee("jerry" ,uid+"@qq.com","1",2));
        }*/
        List<Employee> employees = employeeService.getAll();
        System.out.println(employees.get(1).getdId());

    }

}
