package com.belevitnev.test;

import org.testng.annotations.Test;

import java.sql.*;

public class SqlTest extends BaseTestClass {
    @Test
    public String sqlTest(String query){
        String url = "jdbc:postgresql://192.168.200.26:5432/nim";
        String user = "readonly";
        String password = "4your3y3sonly";
        String result = "d";

        try (Connection connection = DriverManager.getConnection(url,user,password)) {

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {

                result = resultSet.getString("email");

                System.out.println(result);

            }
        }
        catch (SQLException e) {
            System.out.println("failure");
        }
        return result;

    }
}
