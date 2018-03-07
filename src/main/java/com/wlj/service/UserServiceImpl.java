package com.wlj.service;

import com.wlj.dao.TaskDao;
import com.wlj.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wlj.DES.Md5Util;

/**
 * @Author Wuleijian
 * @Date 2018/3/2 12:41
 * @Description
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private TaskDao taskDao;

    public void insert(User user) {
        taskDao.insert(user);
    }

    public User selectUserByName(String name) {
        User username = taskDao.selectUserByName(name);
        return username;
    }

    public void updateTime(String name, long time) {
        taskDao.updateTime(name, time);
    }

    public boolean compare(String name, String password) {

        User user = taskDao.selectUserByName(name);
        try {
            if (user.getName().equals(name) && user.getPassword().equals(password)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}