package com.wlj.dao;

import com.wlj.domain.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskDao {

    List<Student> getAll();

    Integer getLearning();

    Integer getWorking();

    Integer getJava();

    Integer getWeb();

    Integer getMobile();

}
