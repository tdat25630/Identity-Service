package spring_learn.demo.DAL.DAO;


import spring_learn.demo.entity.Permission;

import java.util.List;

public interface PermissionDAO {

    Permission save(Permission permission);
    void deleteById(String id);
    List<Permission> findAll();
    List<Permission> findAllById(Iterable<String> id);
}
