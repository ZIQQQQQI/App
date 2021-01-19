package service;

import dao.IUserDao;
import domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService{
    @Autowired
    private IUserDao userDao;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo u=userDao.findByUserName(username);
        User user=new User(u.getUsername(),"{noop}"+u.getPassword(),getAuthority());
        return null;
    }

    List<SimpleGrantedAuthority> getAuthority(){
        List<SimpleGrantedAuthority> list=new ArrayList<>();
        list.add(new SimpleGrantedAuthority("ROLE_USER"));
        return  list;
    }
}
