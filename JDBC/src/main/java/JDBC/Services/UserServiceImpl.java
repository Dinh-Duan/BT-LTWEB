package JDBC.Services;

import JDBC.Dao.UserDao;
import JDBC.Dao.UserDaoImpl;
import JDBC.Models.UserModel;

public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl();

    @Override
    public UserModel login(String username, String password) {
        UserModel user = this.get(username);
        if (user != null && password.equals(user.getPassWord())) {
            return user;
        }
        return null;
    }

    @Override
    public UserModel get(String username) {
        return userDao.get(username);
    }
}
