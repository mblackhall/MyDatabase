package com.marcus.mydb.repository;

/**
 * @author marcus
 */
public class RepositoryFactory {

    private RepositoryFactory(){}

    public static CompanyRepository getCompanyRepository(){

        return CompanyRepositoryImpl.getInstance();
    }
}
