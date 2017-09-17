package com.github.postsal.service;

import com.github.postsal.bean.Employee;
import com.github.postsal.bean.EmployeeExample;
import com.github.postsal.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by hujian on 2017/9/1.
 */
@Service
public class EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    public List<Employee> getAll(){
        return employeeMapper.selectByExampleWithDept(null);
    }

    /**
     * 检验用户名是否可用
     *
     * @param lastName
     * @return  true：代表当前姓名可用   fasle：不可用
     */
    public boolean checkUser(String lastName) {
        // TODO Auto-generated method stub
        EmployeeExample example = new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();
        criteria.andLastNameEqualTo(lastName);
        long count = employeeMapper.countByExample(example);
        return count == 0;
    }

    /**
     * 员工保存
     * @param employee
     */
    public void saveEmp(Employee employee) {
        // TODO Auto-generated method stub
        employeeMapper.insertSelective(employee);
    }

    /**
     * 按照员工id查询员工
     * @param id
     * @return
     */
    public Employee getEmp(Integer id) {
        // TODO Auto-generated method stub
        Employee employee = employeeMapper.selectByPrimaryKey(id);
        return employee;
    }

    /**
     * 员工更新
     * @param employee
     */
    public void updateEmp(Employee employee) {
        // TODO Auto-generated method stub
        employeeMapper.updateByPrimaryKeySelective(employee);
    }

    /**
     * 员工删除
     * @param id
     */
    public void deleteEmp(Integer id) {
        // TODO Auto-generated method stub
        employeeMapper.deleteByPrimaryKey(id);
    }

    public void deleteBatch(List<Integer> ids) {
        // TODO Auto-generated method stub
        EmployeeExample example = new EmployeeExample();
        EmployeeExample.Criteria criteria = example.createCriteria();
        //delete from xxx where emp_id in(1,2,3)
        criteria.andIdIn(ids);
        employeeMapper.deleteByExample(example);
    }
}
