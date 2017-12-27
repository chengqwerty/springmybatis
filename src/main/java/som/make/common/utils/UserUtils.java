package som.make.common.utils;

import som.make.web.dao.UserDao;
import som.make.web.entity.User;

public class UserUtils {

    private static UserDao userDao = SpringContextHolder.getBean(UserDao.class);


    public static User getUserByUsername(String username) {
        User user = userDao.userQueryByUsername(username);
        if (user == null) {
            return null;
        }
        return user;
    }
}
