package JDBC.Dao;

import JDBC.Models.UserModel;

public interface UserDao {
    UserModel get(String username);
}