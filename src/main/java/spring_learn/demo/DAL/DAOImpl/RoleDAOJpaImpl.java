package spring_learn.demo.DAL.DAOImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import spring_learn.demo.DAL.DAO.RoleDAO;
import spring_learn.demo.entity.Role;
import spring_learn.demo.repository.RoleRepository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class RoleDAOJpaImpl implements RoleDAO {

    private final RoleRepository roleRepository;


    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void deleteById(String id) {
        roleRepository.deleteById(id);
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public List<Role> findAllById(Iterable<String> id) {
        return roleRepository.findAllById(id);
    }
}
