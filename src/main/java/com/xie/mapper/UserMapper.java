package com.xie.mapper;

import com.xie.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("SELECT *  FROM user WHERE name = #{name}")
    User findByName(@Param("name") String name);

    @Insert("INSERT INTO user(name,pwd) VALUES ( #{name},#{pwd})")
    int insert(@Param("name") String name, @Param("pwd") String pwd);

}
