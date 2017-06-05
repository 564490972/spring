package com.abead.db.mapper;

import org.apache.ibatis.annotations.Param;

import com.abead.model.LoginLog;

public interface UserLoginMapper {
      public void updateLog(@Param("data") LoginLog data);
}
