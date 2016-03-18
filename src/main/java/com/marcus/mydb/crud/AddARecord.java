package com.marcus.mydb.crud;

import com.marcus.mydb.setup.DbProperties;

import java.sql.*;

/**
 * @author marcus
 */
public class AddARecord {

    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DbProperties.getUrl(), DbProperties.getUser(), DbProperties.getPassword());

            Statement statement = connection.createStatement();
            int noInserted = statement.executeUpdate("INSERT  INTO company (name,postcode,start_date) VALUES ('Gizmos','1112AA','08-14-1999')");


        } catch (SQLException e) {

            e.printStackTrace();

        }
    }
}
