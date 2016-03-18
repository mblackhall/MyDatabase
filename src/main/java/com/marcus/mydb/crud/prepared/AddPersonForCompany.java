package com.marcus.mydb.crud.prepared;

import com.marcus.mydb.setup.DbProperties;

import java.sql.*;

/**
 * @author marcus
 */
public class AddPersonForCompany {

    public static void main(String[] args) {

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DbProperties.getUrl(), DbProperties.getUser(), DbProperties.getPassword());

          int companyId =  getCompanyId(connection,"acme ltd");

          addPerson(connection,companyId);

        } catch (SQLException e) {

            e.printStackTrace();

        }
    }

    private static void addPerson(Connection connection, int companyId) throws SQLException {

        String sql = "INSERT INTO Employee (firstname,lastname,salary,company_id)" +
                " VALUES(?,?,?,?)";

        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,"John");
        ps.setString(2,"Barkley");
        ps.setDouble(3,50000.56);
        ps.setDouble(4,companyId);

        int noAdded = ps.executeUpdate();

        // now run ...
        // select * from company c left join employee e on e.company_id = c.id

    }

    private static int getCompanyId(Connection connection,String name) throws SQLException {

        String select = "SELECT id FROM company WHERE name = ?";

        PreparedStatement ps = connection.prepareStatement(select);
        ps.setString(1,name);
        ResultSet rs = ps.executeQuery();
        if (rs.next()){
            return rs.getInt(1);
        }

        return 0;

    }


}
