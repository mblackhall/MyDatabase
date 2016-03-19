package com.marcus.mydb.examples;

import com.marcus.mydb.setup.DbProperties;

import java.sql.*;

/**
 * @author marcus
 */
public class DbConnector {

    public static void main(String[] args) {
        Connection connection= null;
        try {

         //   Class.forName(DbProperties.getDriver()); // not required for jdbc
            connection =  DriverManager.getConnection(DbProperties.getUrl(),DbProperties.getUser(),DbProperties.getPassword());

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from company");
            while ( resultSet.next()) {
                // note column indexes start with 1 !
                System.out.println(resultSet.getInt(1) + ":" +resultSet.getString(2));
// can also get values using column name
   //             System.out.println(resultSet.getString("name"));
            }

            resultSet.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }

}
