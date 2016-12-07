package com.app.service.impl;

import com.app.mapper.UserMapper;
import com.app.pojo.User;
import com.app.pojo.UserExample;
import com.app.service.UserService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by heqiyan on 2016/12/5.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findUser() throws Exception {
        List<User> users = userMapper.selectByExample(null);

        return users;
    }

    @Override
    public int saveUser(User user) throws Exception {
       return userMapper.insert(user);
    }

    @Override
    public int modifyUser(User user) throws Exception {
        return userMapper.updateByPrimaryKey(user);
    }

    @Override
    public int deleteUser(User user) throws Exception {
        return userMapper.updateByPrimaryKey(user);
    }

    @Override
    public int deleteUser(int id) throws Exception {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<User> findUserByPage(String page, String rows, UserExample userExample) {
        PageHelper.startPage(Integer.parseInt(page), Integer.parseInt(rows));
        return userMapper.selectByExample(userExample);
    }

}
