package com.kumtakar.test.dao.impl;

import com.kumtakar.test.dao.EmployeeDaoIF;
import com.kumtakar.test.entity.Department;
import com.kumtakar.test.entity.Employee;
import org.springframework.orm.jpa.support.JpaDaoSupport;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: naveen
 * Date: 28/1/11
 * Time: 10:18 PM
 * To change this template use File | Settings | File Templates.
 */

@Transactional(readOnly = true)
public class EmployeeDaoImpl extends JpaDaoSupport implements EmployeeDaoIF
{
    public Employee getEmployeeById(Long employeeId) {
        return getJpaTemplate().find(Employee.class, employeeId);
    }

    public List<Employee> getEmployees() {
        return getJpaTemplate().findByNamedQuery("getAllEmployees");
    }

    public List<Employee> getEmployeesByJoiningDate(Date joiningDateStart, Date joiningDateEnd) {
        Map<String,  Object> paramMap = new HashMap<String, Object>();
        paramMap.put("joiningDateStart",joiningDateStart);
        paramMap.put("joiningDateEnd",joiningDateEnd);
        return getJpaTemplate().findByNamedQueryAndNamedParams("getEmployeesByJoiningDate", paramMap);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    public void saveEmployee(Employee employee) {
        getJpaTemplate().persist(employee);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void updateEmployee(Employee employee) {
        Employee merge = getJpaTemplate().merge(employee);
        Department department = getJpaTemplate().merge(employee.getDepartment());
        merge.setJoiningDate(employee.getJoiningDate());
        merge.setDepartment(department);
        merge.setName(employee.getName());

    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void deleteEmployee(Employee employee) {
        Employee merge = getJpaTemplate().merge(employee);
        getJpaTemplate().remove(merge);
    }
}
