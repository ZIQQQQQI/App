package dao;

import domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IRoleDao {
    @Select("select* from role where id in (select* from users_role where userId=#{id})")
    List<Role> findRoleByUserId(String id);
}
