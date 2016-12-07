package com.app.service;

import com.app.pojo.User;
import com.app.pojo.UserExample;

import java.util.List;

/**
 * Created by heqiyan on 2016/12/5.
 */
public interface UserService {
    List<User> findUser()throws Exception;

    int saveUser(User user) throws Exception;

    int modifyUser(User user) throws Exception;

    int deleteUser(User user) throws Exception;

    int deleteUser(int id) throws Exception;

    List<User> findUserByPage(String page, String rows, UserExample userExample);
}
