package service;

import dao.IRoleDao;
import domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {
    @Autowired
    IRoleDao iRoleDao;
    @Override
    public List<Role> findAll() {
        return iRoleDao.findAll();
    }

    @Override
    public void save(Role role) {
        iRoleDao.save(role);
    }
}
