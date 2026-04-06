package spring_learn.demo.DAL.DAO;

import spring_learn.demo.entity.InvalidatedToken;

public interface InvalidatedTokenDAO {
    void save(InvalidatedToken token);
    boolean existsById(String id);
}
