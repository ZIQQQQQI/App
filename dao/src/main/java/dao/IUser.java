package dao;

import domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IUser {
    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "dao.IRoleDao.findRoleByUserId"))
    })
     UserInfo findByUsername(String username) ;


    @Select("select* from users")
    List<UserInfo> findAll();


    @Insert("insert into users(id,email,username,password,phoneNum,status) values( #{id},#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo);


    @Select("select* from users where id=#{id }")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phoneNum", column = "phoneNum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "dao.IRoleDao.findRoleByUserId")),

    })
    UserInfo findById(String id);
}
