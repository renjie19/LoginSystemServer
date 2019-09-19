package com.lourence.john.loginsystem.employee.repository;

import com.lourence.john.loginsystem.license.repository.License;
import com.lourence.john.loginsystem.section.repository.Section;
import com.lourence.john.loginsystem.subject.repository.Subject;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;
    private String name;
    private int age;
    private String address;
    private String position;
    @OneToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn
    private License license;
    @OneToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn
    private List<Subject> subjectList;
    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST})
    @JoinColumn
    private List<Section> sectionList;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public License getLicense() {
        return license;
    }

    public void setLicense(License license) {
        this.license = license;
    }

    public List<Subject> getSubjectList() {
        return subjectList;
    }

    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }

    public List<Section> getSectionList() {
        return sectionList;
    }

    public void setSectionList(List<Section> sectionList) {
        this.sectionList = sectionList;
    }
}
