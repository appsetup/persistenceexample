package com.kumtakar.test.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: naveen
 * Date: 29/1/11
 * Time: 1:55 PM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "T_DEPARTMENT")
public class Department {
    @Id
    Long id;

    @Column(name="department_name")
    String departmentName;

    @ManyToOne(targetEntity = Employee.class)
    List<Employee> employees;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Employee> getEmployees() {
        return employees == null ? new ArrayList<Employee>():employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
