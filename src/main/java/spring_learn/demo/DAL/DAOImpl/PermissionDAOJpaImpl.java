package spring_learn.demo.DAL.DAOImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import spring_learn.demo.DAL.DAO.PermissionDAO;
import spring_learn.demo.entity.Permission;
import spring_learn.demo.repository.PermissionRepository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class PermissionDAOJpaImpl implements PermissionDAO {

    private final PermissionRepository permissionRepository;

    @Override
    public Permission save(Permission permission) {
        return permissionRepository.save(permission);
    }

    @Override
    public void deleteById(String id) {
        permissionRepository.deleteById(id);
    }

    @Override
    public List<Permission> findAll() {
        return permissionRepository.findAll();
    }

    @Override
    public List<Permission> findAllById(Iterable<String> ids) {
        return permissionRepository.findAllById(ids);
    }
}
