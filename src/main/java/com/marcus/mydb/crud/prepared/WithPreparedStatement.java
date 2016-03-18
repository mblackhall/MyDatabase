package com.marcus.mydb.crud.prepared;

import com.marcus.mydb.setup.DbProperties;

import java.sql.*;

/**
 * @author marcus
 */
public class WithPreparedStatement {
    public static void main(String[] args) {

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DbProperties.getUrl(), DbProperties.getUser(), DbProperties.getPassword());

            int noRead = getRecords(connection,"1012VC");
            System.out.println("No read  : " + noRead );

            int noRead2 = getRecords(connection,"1012VC' OR 'x' = 'x");
            System.out.println("No read : " + noRead2 );


        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    public static int getRecords(Connection conn, String postcode) throws SQLException {

        String updateString =
                "SELECT * FROM company where postcode = ?";
        PreparedStatement statement = conn.prepareStatement(updateString);

        statement.setString(1,postcode);
        ResultSet rs =  statement.executeQuery();

        int noUpdate = 0;
        while (rs.next()){
            noUpdate ++;

        }
        return noUpdate;
    }

}
