package com.sym.service.impl;

import com.github.pagehelper.PageHelper;
import com.sym.mapper.UserMapper;
import com.sym.model.User;
import com.sym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "userService")
public class UserSeriveImpl implements UserService {
    @Autowired
    private UserMapper userMapper;//这里会报错，但是并不会影响

    @Override
    public List<User> findAllUser(int pageNum, int pageSize) {
        //将参数传给这个方法就可以实现物理分页了，非常简单。
        PageHelper.startPage(pageNum, pageSize);
        return userMapper.selectAllUser();
    }


    @Transactional(rollbackFor=Exception.class)
    @Override
    public int addUser(User user) {
        int id = userMapper.insertSelective(user);
        throw new RuntimeException();
    }

}
