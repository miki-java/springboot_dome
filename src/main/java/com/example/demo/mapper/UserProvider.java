package com.example.demo.mapper;

import com.example.demo.model.Person;
import com.github.pagehelper.util.StringUtil;

/**
 * Created by hmq on 2018/11/8.
 */
public class UserProvider {

    public String findUserByPersonInfoSql(Person person){
        StringBuilder sb = new StringBuilder("select * from t_user where 1 = 1");
        if(person != null){
            if(StringUtil.isNotEmpty(person.getName())){
                sb.append( " and name like '%"+person.getName()+"%'");
            }
            if(null != person.getAge() && person.getAge()!= 0 ){
                sb.append( " and age = "+person.getAge());
            }
        }
        return sb.toString();
    }
}
