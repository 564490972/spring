package com.abead.db.mapper;

import org.apache.ibatis.annotations.Param;

import com.abead.model.LoginLog;

import java.util.List;

public interface UserLoginMapper {
      public void updateLog(@Param("data") LoginLog data);
      public List<LoginLog> select(@Param("id") int id);
      public List<LoginLog> selectAll();
}
