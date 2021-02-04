package service;

import domain.Permission;

import java.util.List;

public interface IPermissionService {
    List<Permission> findAll();

    void save(Permission permission);
    Permission findById(String id) throws Exception;
}
