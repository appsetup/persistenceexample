package com.kumtakar.test;

import com.kumtakar.test.broker.EmployeeBroker;
import com.kumtakar.test.entity.Department;
import com.kumtakar.test.entity.Employee;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: naveen
 * Date: 28/1/11
 * Time: 11:23 PM
 * To change this template use File | Settings | File Templates.
 */
public class EmployeeTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring-config.xml");
        EmployeeBroker employeeBroker = classPathXmlApplicationContext.getBean("employeeBroker", EmployeeBroker.class);
        Employee employee = new Employee();
        employee.setId(1l);
        employee.setName("Naveen");
        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.DATE,23);
        instance.set(Calendar.MONTH,Calendar.OCTOBER);
        instance.set(Calendar.YEAR, 9);
        employee.setJoiningDate(instance.getTime());
        Department department = new Department();
        department.setId(1l);
        employee.setDepartment(department);
        employeeBroker.updateEmployee(employee);
//        List<Employee> employeesByJoiningDate = employeeBroker.getEmployeesByJoiningDate(instance.getTime(), instance.getTime());
//        for (Employee employee : employeesByJoiningDate) {
//            System.out.println("employee = " + employee);
//        }
    }
}
