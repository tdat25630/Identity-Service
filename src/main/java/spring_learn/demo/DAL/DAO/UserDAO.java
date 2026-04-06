package spring_learn.demo.DAL.DAO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import spring_learn.demo.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDAO {

    boolean existsByUsername(String username);
    Optional<User> findByUsername(String username);
    User save(User user);
    Optional<User> findById(String id);
    void deleteById(String id);
    Page<User> findAll(Pageable pageable);
    Page<User> findByUserNameV2(String keyword, Pageable pageable);
}
