package com.abead.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abead.db.mapper.UserLoginMapper;
import com.abead.model.LoginLog;

@Service
public class UserService {
	   @Autowired
       private UserLoginMapper userLoginMapper;
	   
	   public void update(LoginLog log){
		   userLoginMapper.updateLog(log);
	   }
}
