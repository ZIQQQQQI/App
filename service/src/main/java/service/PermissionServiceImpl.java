package service;

import dao.IPermissionDao;
import domain.Permission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PermissionServiceImpl implements IPermissionService{
    @Autowired
    IPermissionDao iPermissionDao;

    @Override
    public List<Permission> findAll() {
        return iPermissionDao.findAll();
    }

    @Override
    public void save(Permission permission) {
        iPermissionDao.save(permission);
    }


    @Override
    public Permission findById(String id) throws Exception {
        return iPermissionDao.findById(id);
    }
}
