package com.kumtakar.test.dao;

import com.kumtakar.test.entity.Employee;

import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: naveen
 * Date: 28/1/11
 * Time: 10:15 PM
 * To change this template use File | Settings | File Templates.
 */
public interface EmployeeDaoIF {
    public Employee getEmployeeById(Long employeeId);

    public List<Employee> getEmployees();

    public List<Employee> getEmployeesByJoiningDate(Date joiningDateStart, Date joiningDateEnd);

    public void saveEmployee(Employee employee);

    public void updateEmployee(Employee employee);

    public void deleteEmployee(Employee employee);
}
