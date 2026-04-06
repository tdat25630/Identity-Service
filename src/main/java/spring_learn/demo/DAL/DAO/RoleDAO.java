package spring_learn.demo.DAL.DAO;

import spring_learn.demo.entity.Role;

import java.util.List;

public interface RoleDAO {
        Role save(Role role);
        void deleteById(String id);
        List<Role> findAll();
        List<Role> findAllById(Iterable<String> id);
}
