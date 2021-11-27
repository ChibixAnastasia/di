package com.example.di;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;



    @Test
    public void createTable() throws SQLException {
        userRepository.createTable();
        userRepository.insertData();
        int count = userRepository.findAll().size();
        Assert.assertEquals(3, count);
    }


}