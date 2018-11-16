package com.example.demo.mapper;

import com.example.demo.model.Person;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by hmq on 2018/11/6.
 */

@Repository
public interface UserMapper {

    @Select("select * from t_user")
    List<Person> findUsers();

    @Select("select * from t_user where id = #{id}")
    Person findUserById(@Param("id") Integer id);

    @SelectProvider(type = UserProvider.class, method = "findUserByPersonInfoSql")
    List<Person> findUserByPersonInfo(Person person);

    @Insert("insert into t_user(name,age,birthday,description)values(#{name},#{age},null,#{description})")
    @Options(useGeneratedKeys=true, keyColumn="id")
    Integer insertUser(Person person);


}