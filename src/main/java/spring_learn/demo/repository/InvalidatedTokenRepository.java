package spring_learn.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring_learn.demo.entity.InvalidatedToken;

public interface InvalidatedTokenRepository extends JpaRepository<InvalidatedToken,String> {
}
