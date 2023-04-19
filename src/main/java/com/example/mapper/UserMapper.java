package com.example.mapper;

import com.example.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> getAll();

    User getOne(Long id);

    User getUserByName(@Param("username")String username);

    void insert(User user);

    void update(User user);

    void delete(Long id);
}
