package com.mace.mapper;

import com.mace.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    List<User> getUserList();

    User getUserById(int id);

    int insertUser(User user);

    int updateUser(Map<String, Object> map);

    int deleteUser(int id);

    List<User> getUserLike(String value);
}
