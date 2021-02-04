package service;

import domain.Role;
import domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {
    void save(UserInfo userInfo);

    UserInfo findById(String id);
    List<Role> findOtherRoles(String userId) throws Exception;

    void addRoleToUser(String userId, String[] roleIds);
    List<UserInfo> findAll() throws Exception;
}
