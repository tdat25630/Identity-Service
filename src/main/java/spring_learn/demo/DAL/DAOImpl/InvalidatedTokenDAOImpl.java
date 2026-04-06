package spring_learn.demo.DAL.DAOImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import spring_learn.demo.DAL.DAO.InvalidatedTokenDAO;
import spring_learn.demo.entity.InvalidatedToken;
import spring_learn.demo.repository.InvalidatedTokenRepository;


@Repository
@RequiredArgsConstructor
public class InvalidatedTokenDAOImpl implements InvalidatedTokenDAO {

    private final InvalidatedTokenRepository invalidatedTokenRepository;

    @Override
    public void save(InvalidatedToken token) {
        invalidatedTokenRepository.save(token);
    }

    @Override
    public boolean existsById(String id) {
        return invalidatedTokenRepository.existsById(id);
    }
}
