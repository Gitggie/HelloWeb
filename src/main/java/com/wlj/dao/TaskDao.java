package com.wlj.dao;

import com.wlj.domain.Student;
import com.wlj.domain.User;
import org.apache.ibatis.annotations.Param;
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

    /**
     * @Author Wuleijian
     * @Date 2018/3/2 12:38
     * @Description task5
     */
    void insert(User user);

    User selectUserByName(String name);

    void updateTime(@Param("name") String name, @Param("time") long time);

}
