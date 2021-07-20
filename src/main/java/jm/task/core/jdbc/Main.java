package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Daulet", "Lepessov", (byte) 20);
        userService.saveUser("Naruto", "Uzumaki", (byte) 20);
        userService.saveUser("Ali", "Chert", (byte) 20);
        userService.saveUser("Gala", "Chert", (byte) 20);
        List<User> l = userService.getAllUsers();
        System.out.println(l);
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
