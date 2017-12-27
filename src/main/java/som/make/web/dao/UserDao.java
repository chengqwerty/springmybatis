package som.make.web.dao;

import org.springframework.stereotype.Repository;
import som.make.web.entity.User;

@Repository
public interface UserDao {

    User userQueryByUsername(String username);
}
