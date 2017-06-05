package com.abead.services;

import com.abead.model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abead.db.mapper.UserLoginMapper;
import com.abead.model.LoginLog;

import java.util.List;

@Service
public class UserService {

    Logger logger = Logger.getLogger(UserService.class);
    @Autowired
    private UserLoginMapper userLoginMapper;

    @Autowired
    private User user;

    public void update(LoginLog log) {
        userLoginMapper.updateLog(log);
    }

    public List<LoginLog> select(int id) {
        if(id <= 0){
            logger.error("id不合法");
            logger.debug("id不合法");
            return null;
        }
        return userLoginMapper.select(id);
    }

    public List<LoginLog> selectAll() {
        return userLoginMapper.selectAll();
    }
}
