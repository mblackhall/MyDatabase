package com.marcus.mydb.examples;

import com.marcus.mydb.setup.DbProperties;

import java.sql.*;

/**
 * @author marcus
 */
public class RSMetaData {

    public static void main(String[] args) {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DbProperties.getUrl(), DbProperties.getUser(), DbProperties.getPassword());

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from Country ");
            ResultSetMetaData metaData = resultSet.getMetaData();
            int noColumns = metaData.getColumnCount();
            for(int i=1;i<=noColumns;i++){
                System.out.printf("%-15s",metaData.getColumnName(i));
            }
            System.out.println("");

            while (resultSet.next()) {
                // note column indexes start with 1 !
                System.out.printf("%-15s%-30s%-15s\n",resultSet.getInt(1),resultSet.getString(2),resultSet.getTime(3));
// can also get values using column name
            }

            resultSet.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }
}
