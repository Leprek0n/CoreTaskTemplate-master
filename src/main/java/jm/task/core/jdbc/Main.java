package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoJDBCImpl();
        userDao.createUsersTable();
        userDao.saveUser("Daulet", "Lepessov", (byte) 20);
        userDao.saveUser("Naruto", "Uzumaki", (byte) 20);
        userDao.saveUser("Ali", "Chert", (byte) 20);
        userDao.saveUser("Gala", "Chert", (byte) 20);
        List<User> l = userDao.getAllUsers();
        System.out.println(l);
        userDao.cleanUsersTable();
        userDao.dropUsersTable();
    }
}
