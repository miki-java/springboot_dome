package com.example.demo.service;

import com.example.demo.common.ApiResult;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.Person;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by hmq on 2018/11/6.
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<Person> findUsers(){
        return userMapper.findUsers();
    }

    public ApiResult findUserByPage(Integer page,Integer size){
        PageHelper.startPage(page,size);
        List<Person> users = userMapper.findUsers();
        PageInfo<List<Person>> info = new PageInfo(users);
        ApiResult apiResult = new ApiResult();
        apiResult.setData(info.getList());
        apiResult.setPage(page);
        apiResult.setCount(info.getTotal());
        return apiResult;
    }

    public ApiResult findUserById(Integer id){
        ApiResult apiResult = new ApiResult();
        Person person = userMapper.findUserById(id);
        apiResult.setData(person);
        return apiResult;
    }

    public ApiResult findUserByPersonInfo(Person person){
        ApiResult apiResult = new ApiResult();
        List<Person> list = userMapper.findUserByPersonInfo(person);
        apiResult.setData(list);
        return apiResult;
    }

    public ApiResult saveUser(Person person){
        ApiResult apiResult = new ApiResult();
        Integer code = userMapper.insertUser(person);
        System.out.println(code.toString());
        apiResult.setMsg("successful");
        return apiResult;
    }
}
