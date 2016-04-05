package com.marcus.mydb.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author marcus
 */
public class Company {

    public Company(){

        this.id = new SimpleIntegerProperty(0);
        this.name = new SimpleStringProperty(null);
        this.postcode  =new SimpleStringProperty(null);
    }

    private SimpleIntegerProperty id;
    private  SimpleStringProperty  name;
    private SimpleStringProperty postcode;
    private SimpleStringProperty startdate;

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }
    public String getStartdate() {
        if (startdate == null) return null;

        return startdate.get();
    }

    public SimpleStringProperty dateProperty() {
        return startdate;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getPostcode() {
        return postcode.get();
    }

    public SimpleStringProperty postcodeProperty() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode.set(postcode);
    }

    public Company(int id, String name, String postcode,Date startdate) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.postcode  =new SimpleStringProperty(postcode);

        if ( startdate != null ){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            this.startdate = new SimpleStringProperty(sdf.format(startdate));
        }


    }


}
