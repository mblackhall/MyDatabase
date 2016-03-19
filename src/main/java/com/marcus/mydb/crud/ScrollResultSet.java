package com.marcus.mydb.crud;

import com.marcus.mydb.setup.DbProperties;

import java.sql.*;

/**
 * @author marcus
 */
public class ScrollResultSet {

    public static void main(String[] args) {
        Connection connection= null;
        try {
            connection =  DriverManager.getConnection(DbProperties.getUrl(),DbProperties.getUser(),DbProperties.getPassword());

            // default is resultset.TYPE_FORWARD_ONLY !
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = statement.executeQuery("Select * from company");

            boolean lastfound = resultSet.last();
            if ( lastfound){
                System.out.println("Last company is : " +resultSet.getString("name"));
            }

            // and you can go back ...

            if (resultSet.previous()){
                System.out.println("now company is : " +resultSet.getString("name"));
            }

            // or position to exact record...

            if (resultSet.absolute(1)){
                System.out.println("first company is : " +resultSet.getString("name"));
                // we can even update it
                resultSet.updateString("postcode","NNNN11");
                resultSet.updateRow();
            }

            // special insert row !!
            resultSet.moveToInsertRow();
            resultSet.updateString("name","company");
            resultSet.insertRow();
            resultSet.moveToCurrentRow();




            resultSet.close();

        } catch (SQLException e) {

            e.printStackTrace();

        }



    }
}
