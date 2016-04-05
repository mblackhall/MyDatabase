package com.marcus.mydb.repository;

import com.marcus.mydb.model.Company;

import java.util.List;

/**
 * @author marcus
 */
public interface CompanyRepository {

    public int addCompany(Company company);

    public int deleteCompany(int id);

    public List<Company> getAll();


}
