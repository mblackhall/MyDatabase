package com.marcus.mydb.repository;

import com.marcus.mydb.datasource.ConnectionFactory;
import com.marcus.mydb.model.Company;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author marcus
 */
public class CompanyRepositoryImpl implements CompanyRepository {

    private static CompanyRepository companyRepository = new CompanyRepositoryImpl();

    private CompanyRepositoryImpl() {

    }

    static public CompanyRepository getInstance() {
        return companyRepository;
    }

    @Override
    public int addCompany(Company company) {

        Connection conn = null;
        try {
            conn = ConnectionFactory.getDataSource().getConnection();

            PreparedStatement statement = conn.prepareStatement("INSERT INTO company (name,postcode) VALUES (?,?)",Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, company.getName());
            statement.setString(2, company.getPostcode());
            statement.executeUpdate();

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    company.setId(generatedKeys.getInt("id"));
                }
                else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 1;


    }

    @Override
    public int deleteCompany(int id) {
        return 0;
    }

    @Override
    public List<Company> getAll() {
        //
        DataSource ds = ConnectionFactory.getDataSource();
        List<Company> company = new ArrayList<>();
        try {
            Connection conn = ds.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from company");
            while (resultSet.next()) {
                System.out.println(resultSet.getDate("start_date"));
                company.add(new Company(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("postcode"),
                        resultSet.getDate("start_date")));


            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return company;
    }
}
