package com.abead.services;

import com.abead.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abead.db.mapper.UserLoginMapper;
import com.abead.model.LoginLog;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserLoginMapper userLoginMapper;

    @Autowired
    private User user;

    public void update(LoginLog log) {
        userLoginMapper.updateLog(log);
    }

    public List<LoginLog> select(int id) {
        return userLoginMapper.select(id);
    }

    public List<LoginLog> selectAll() {
        return userLoginMapper.selectAll();
    }
}
