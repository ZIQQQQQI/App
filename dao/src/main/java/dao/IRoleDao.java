package dao;

import domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IRoleDao {

    //find role by id
    @Select("select * from role where id in (select roleId from users_role where userId=#{userId})")
    @Results(
            {
                    @Result(id = true,property = "id",column = "id"),
                    @Result(property = "roleName",column = "roleName"),
                    @Result(property ="roleDesc",column = "roleDesc"),
                    @Result(property = "permissions",column = "id",javaType = java.util.List.class,many=@Many(select="dao.IPermissionDao.findPermissionByRoleId"))
            }
    )
    List<Role> findRoleByUserId(String userId) throws Exception;

    @Select("select* from role")
    List<Role> findAll();

    @Insert("insert into role values(#{id},#{roleName},#{roleDesc})")
    void save(Role role);
}
