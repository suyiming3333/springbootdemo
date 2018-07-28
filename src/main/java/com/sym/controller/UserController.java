package com.sym.controller;


import com.sym.model.User;
import com.sym.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/all/{pageNum}/{pageSize}", produces = {"application/json;charset=UTF-8"})
    public Object findAllUser(@PathVariable("pageNum") int pageNum, @PathVariable("pageSize") int pageSize) {
        System.out.println("user service");
        return userService.findAllUser(pageNum, pageSize);
    }

    @ResponseBody
    @RequestMapping(value = "/add", produces = {"application/json;charset=UTF-8"})
    public int addUser(User user){
        user.setAge(40);
        user.setUsername("ayue");
        return userService.addUser(user);
    }

    @ResponseBody
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public Object sayHello() {
        System.out.println("user service hello");
        return null;
    }

}
