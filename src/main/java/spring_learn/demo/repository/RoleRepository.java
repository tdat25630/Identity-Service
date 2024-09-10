package spring_learn.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_learn.demo.entity.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role,String> {
}
