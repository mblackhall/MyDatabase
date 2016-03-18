package com.marcus.mydb.crud;

import com.marcus.mydb.setup.DbProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author marcus
 */
public class UpdateARecord {

    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DbProperties.getUrl(), DbProperties.getUser(), DbProperties.getPassword());

            Statement statement = connection.createStatement();
            int noUpdated = statement.executeUpdate("UPDATE company set postcode = 'ssss' where name like 'ac%' ");
            System.out.println("No updates : " + noUpdated);

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }
}
