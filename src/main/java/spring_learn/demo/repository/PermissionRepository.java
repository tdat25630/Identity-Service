package spring_learn.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring_learn.demo.entity.Permission;
import spring_learn.demo.entity.User;

import java.util.Optional;

@Repository
public interface PermissionRepository extends JpaRepository<Permission,String> {


}
