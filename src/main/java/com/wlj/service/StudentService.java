package com.wlj.service;

import com.wlj.domain.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAll();

    Integer getLearning();

    Integer getWorking();

    Integer getJava();

    Integer getWeb();

    Integer getMobile();

}
