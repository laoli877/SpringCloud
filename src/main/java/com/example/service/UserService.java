package com.example.service;

import com.example.mapper.UserMapper;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService implements UserDetailsService {

@Autowired
UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userMapper.getUserByName(username);
        if(user ==null) throw new UsernameNotFoundException("==============用户"+username+"不存在==============");
        return org.springframework.security.core.userdetails.User.withUsername(user.getUserName())
                .password(user.getPassWord()).roles("user")
                .build();
    }
}

