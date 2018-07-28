package com.sym.service;

import com.sym.model.User;

import java.util.List;

public interface UserService {

    List<User> findAllUser(int pageNum, int pageSize);

    int addUser(User user);

}
