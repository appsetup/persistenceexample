package com.kumtakar.test.broker;

import com.kumtakar.test.dao.EmployeeDaoIF;
import com.kumtakar.test.entity.Employee;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: naveen
 * Date: 28/1/11
 * Time: 11:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class EmployeeBroker
{

    @Value("#{employeeDao}")
    private EmployeeDaoIF employeeDao;

    public Employee getEmployeeById(Long employeeId) {
        return employeeDao.getEmployeeById(employeeId);
    }

    public List<Employee> getEmployees() {
        return employeeDao.getEmployees();
    }

    public List<Employee> getEmployeesByJoiningDate(Date joiningDateStart, Date joiningDateEnd) {
        return employeeDao.getEmployeesByJoiningDate(joiningDateStart,joiningDateEnd);
    }

    public void saveEmployee(Employee employee) {
        employeeDao.saveEmployee(employee);
    }

    public void updateEmployee(Employee employee) {
        employeeDao.updateEmployee(employee);
    }

    public void deleteEmployee(Employee employee) {
        employeeDao.deleteEmployee(employee);
    }

    public EmployeeDaoIF getEmployeeDao() {
        return employeeDao;
    }

    public void setEmployeeDao(EmployeeDaoIF employeeDao) {
        this.employeeDao = employeeDao;
    }
}
