package com.marcus.mydb.datasource;

import com.marcus.mydb.setup.DbProperties;
import org.apache.commons.dbcp2.BasicDataSource;

import javax.sql.DataSource;

/**
 * @author marcus
 */
public class ConnectionFactory {

    private static BasicDataSource datasource;

    static {
        setUpDataSource();
    }

    private ConnectionFactory(){

    }
    private static void setUpDataSource() {

        datasource = new BasicDataSource();
        datasource.setInitialSize(10);
        datasource.setUrl(DbProperties.getUrl());
        datasource.setUsername(DbProperties.getUser());
        datasource.setPassword(DbProperties.getPassword());

    }

    public static DataSource getDataSource(){

        return datasource;
    }

    public static void displayDataSource(){

        System.out.printf("Initial size :%30s\nMax Total :%30s\nMax Idle :%30s\nNo.acive :%30s\n",datasource.getInitialSize(),
        datasource.getMaxTotal(),
        datasource.getMaxIdle(),
                datasource.getNumActive());


    }

}
