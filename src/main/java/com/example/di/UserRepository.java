package com.example.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepository {
    private Statement statement;
    @Autowired
    DataSource dataSource;

    public UserRepository() {
        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            java.sql.Connection connection = dataSource.getConnection("sa","sa");
            statement = connection.createStatement();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<User> findAll() throws SQLException {
        List<User> users = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery("Select * from Users");
        while (resultSet.next()) {
            Long id = resultSet.getLong(0);
            String name = resultSet.getString(1);
            String email = resultSet.getString(2);
            users.add(new User(id, name, email));
        }
        return users;
    }

    public void createTable() throws SQLException {
        statement.executeQuery("CREATE TABLE Users(" +
                "id BIGINT, " +
                "name VARCHAR(20)," +
                "email VARCHAR(20));");
    }

    public void insertData() throws SQLException {
        statement.executeQuery("INSERT INTO Users(id, name, email) VALUES " +
                "(0, 'Vasya', 'vavya.gmail')," +
                "(1, 'Petya', 'petya.gmail')," +
                "(2, 'Sasha', 'sashs.gmail')," +
                "");
    }
}
