package com.belevitnev.test;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.sql.*;

public class BaseTestClass {

    @BeforeSuite
    public void firstRun() {
        System.out.println("First test runned");

        String url = "jdbc:postgresql://192.168.200.26:5432/nim";
        String user = "readonly";
        String password = "4your3y3sonly";
        String sql = "SELECT * FROM user_detail WHERE user_detail.email='gukomzi@yopmail.com'";


        try (Connection connection = DriverManager.getConnection(url,user,password)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {

                System.out.println(resultSet.getString(1));
            }
        }
        catch (SQLException e) {
            System.out.println("failure");
        }
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before class");
    }

    @AfterSuite
    public  void afterSuit(){
        System.out.println("After suit Last method");
    }
}
