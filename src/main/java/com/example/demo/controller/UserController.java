package com.example.demo.controller;

import com.example.demo.common.ApiResult;
import com.example.demo.model.Person;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * Created by hmq on 2018/11/6.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/query/users",method = RequestMethod.GET)
    public List<Person> findUsers(){
        return userService.findUsers();
    }
    @RequestMapping("/test")
    public Person test(){
        Person person = new Person();
        person.setAge(18);
        person.setBirthday(new Date());
        System.out.printf(new Date().toString());
        return person;
    }
    @RequestMapping("/query/page")
    public ApiResult findUserByPage(@RequestParam(name="page") Integer page, @RequestParam(name="size") Integer size){
        return userService.findUserByPage(page, size);
    }

    @RequestMapping("/query/user/{id}")
    public ApiResult findUserById(@PathVariable(name="id") Integer id){
       return userService.findUserById(id);
    }

    @RequestMapping("/query/user1")
    public ApiResult findUserById1(@RequestParam(name="id") Integer id){
        return userService.findUserById(id);
    }

    @PostMapping("/test/body")
    public String testBodyParam(@RequestBody Person person){
        return person.toString();
    }

    @RequestMapping("/condition/query/user")
    public ApiResult findUserByPersonInfo(Person person){
        return userService.findUserByPersonInfo(person);
    }

    @PostMapping("/save/user")
    public ApiResult saveUser(@RequestBody Person person){
        return userService.saveUser(person);
    }
}
