package com.marcus.mydb.crud.prepared;

import com.marcus.mydb.setup.DbProperties;
import java.sql.*;

/**
 * @author marcus
 */

public class SqlInjection {

    public static void main(String[] args) {

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DbProperties.getUrl(), DbProperties.getUser(), DbProperties.getPassword());

            int noRead = getRecords(connection,"ssss");
            System.out.println("No read : " + noRead );

            int noRead2 = getRecords(connection,"ssss' OR 'x' = 'x");
            System.out.println("No read : " + noRead2 );


        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    public static int getRecords(Connection conn, String postcode) throws SQLException {

        Statement statement = conn.createStatement();
        String updateString =
                "SELECT * FROM company where postcode = '" + postcode + "'";
        System.out.println(updateString);
        ResultSet rs =  statement.executeQuery(updateString);
        int noUpdate = 0;
        while (rs.next()){
            noUpdate ++;

        }
        return noUpdate;
    }


}
