package service;

import domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends UserDetailsService {
    void save(UserInfo userInfo);

    UserInfo findById(String id);
}
