package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    Util util = new Util();
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try (Statement statement = util.getConnection().createStatement()) {

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS UsersTable (id MEDIUMINT NOT NULL AUTO_INCREMENT, "
                    + "name CHAR(40) NOT NULL, "
                    + "lastname CHAR(40) NOT NULL, "
                    + "age int(127) NOT NULL, primary key (id))");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        try (Statement statement = util.getConnection().createStatement()) {
            statement.executeUpdate("DROP TABLE IF EXISTS userstable");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try (PreparedStatement statement = util.getConnection().prepareStatement("INSERT INTO userstable(name, lastName, age) VALUES( ?, ?, ?)")) {
            statement.setString(1, name);
            statement.setString(2, lastName);
            statement.setByte(3, age);
            statement.executeUpdate();
            util.getConnection().setAutoCommit(false);
            util.getConnection().commit();
            System.out.println("User  именем - " + name + " был добавлен в базу данных");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        try (Statement statement = util.getConnection().createStatement()) {
            statement.execute("DELETE FROM userstable WHERE id=" + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        try (PreparedStatement preparedStatement = util.getConnection().prepareStatement("SELECT * FROM userstable");
             ResultSet resultSet = preparedStatement.executeQuery("SELECT * FROM userstable")) {
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));
                list.add(user);
                util.getConnection().commit();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    public void cleanUsersTable() {
        try (Statement statement = util.getConnection().createStatement()) {
            statement.execute("TRUNCATE userstable");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
