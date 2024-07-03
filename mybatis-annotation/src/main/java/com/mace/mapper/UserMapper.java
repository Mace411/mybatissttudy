package com.mace.mapper;

import com.mace.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    @Select("select * from user")
    List<User> getUserList();

    @Select("select * from user where id = #{id}")
    User getUserById(int id);

    @Insert("insert into user (id,name,psw) values(#{id},#{name},#{psw})")
    int insertUser(User user);

    int updateUser(Map<String, Object> map);

    int deleteUser(int id);

    List<User> getUserLike(String value);

}
