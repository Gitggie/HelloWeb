package com.wlj.service;

import com.wlj.domain.User;

/**
 * @Author Wuleijian
 * @Date 2018/3/2 12:39
 * @Description
 */
public interface UserService {
    void insert(User user);

    User selectUserByName(String name);

    boolean compare(String name, String password);

    void updateTime(String name, long time);
}
