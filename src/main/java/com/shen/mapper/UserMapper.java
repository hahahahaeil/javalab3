package com.shen.mapper;

import com.shen.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

//这个注解表示这是一个mybatis的mapper
@Mapper
@Repository
public interface UserMapper {
    // 插入新用户
    void insertUser(User user);

    // 根据 id 查找用户
    User getUserById(Integer id);

    // 根据 id 和密码检查用户是否存在
    User checkLogin(Integer id, String password);

    User getUserById(String id);
}
