package com.marcus.mydb.crud;

import com.marcus.mydb.datasource.ConnectionFactory;

import javax.sql.DataSource;
import java.sql.*;

/**
 * @author marcus
 */
public class AddARecord {

    public static void main(String[] args) throws InterruptedException {
        Connection connection = null;
        try {

            DataSource ds = ConnectionFactory.getDataSource();
            ConnectionFactory.displayDataSource();

            connection = ds.getConnection();

            ConnectionFactory.displayDataSource();
            Thread.sleep(10000);


            PreparedStatement statement = connection.prepareStatement("SELECT * from company");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next() ){
                System.out.println(resultSet.getInt(1));
            }

            Thread.sleep(10000);


            ResultSet resultSet2 = statement.executeQuery();
            while (resultSet2.next() ){
                System.out.println(resultSet2.getInt(1));
            }
            Thread.sleep(10000);

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }
}
