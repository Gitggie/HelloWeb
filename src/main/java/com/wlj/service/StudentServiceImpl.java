package com.wlj.service;

import com.wlj.dao.TaskDao;
import com.wlj.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private TaskDao taskDao;

    public List<Student> getAll() {
        return taskDao.getAll();
    }

    public Integer getLearning() {
        return taskDao.getLearning();
    }

    public Integer getWorking() {
        return taskDao.getWorking();
    }

    public Integer getJava() {
        return taskDao.getJava();
    }

    public Integer getWeb() {
        return taskDao.getWeb();
    }

    public Integer getMobile() {
        return taskDao.getMobile();
    }
}

