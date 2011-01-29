package com.kumtakar.test.entity;

import sun.beans.editors.IntEditor;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: naveen
 * Date: 28/1/11
 * Time: 9:47 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "T_EMPLOYEE")
@NamedQueries({@NamedQuery(name = "getAllEmployees", query = "select e from Employee e"),
        @NamedQuery(name = "getEmployeesByJoiningDate", query = "select e from Employee e where e.joiningDate >= :joiningDateStart " +
                "and e.joiningDate <= :joiningDateEnd")})

public class Employee {
    @Id
    @Column
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column(name = "joining_date")
    @Temporal(value = TemporalType.DATE)
    private Date joiningDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != null ? !id.equals(employee.id) : employee.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", joiningDate=" + joiningDate +
                '}';
    }
}
