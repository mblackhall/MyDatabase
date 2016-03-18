package com.marcus.mydb.crud;

import com.marcus.mydb.setup.DbProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author marcus
 */
public class DeleteARecord {

    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DbProperties.getUrl(), DbProperties.getUser(), DbProperties.getPassword());

            Statement statement = connection.createStatement();
            int noDeleted = statement.executeUpdate("DELETE FROM company WHERE name = 'Gizmos' ");
            if (noDeleted == 1){
                System.out.println("Deleted succussfully");
            }

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }
}
