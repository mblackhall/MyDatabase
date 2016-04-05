package com.marcus.mydb.forms;

import com.marcus.mydb.model.Company;
import com.marcus.mydb.repository.RepositoryFactory;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * @author marcus
 */
public class AddCompanyForm {

    final Stage stage;
    Scene scene;
    TextField nameTextField;
    TextField postcodeTextField;
    ObservableList<Company> companyList;


    public AddCompanyForm() {

        stage = new Stage();
        stage.setWidth(400);
        stage.setHeight(300);

        stage.setTitle("Add Company");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Label userName = new Label("Company Name :");
        grid.add(userName, 0, 1);

        nameTextField = new TextField();
        grid.add(nameTextField, 1, 1);

        final Label pw = new Label("Postcode :");
        grid.add(pw, 0, 2);
        postcodeTextField = new TextField();
        grid.add(postcodeTextField, 1, 2);

        Button add = new Button("Add");
        Button cancel = new Button("Cancel");

        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                Company company = new Company();
                String name = nameTextField.getText().trim();

                company.setName(name);
                company.setPostcode(postcodeTextField.getText().trim());
                RepositoryFactory.getCompanyRepository().addCompany(company);

                if ( companyList != null){
                    companyList.add(company);
                }

                stage.close();
            }
        });

        cancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.close();
            }
        });
        HBox hbox = new HBox();
        hbox.setSpacing(10);
        hbox.getChildren().addAll(add,cancel);

        grid.add(hbox, 1, 3);

        scene = new Scene(grid, 300, 275);
        stage.setScene(scene);


    }
    public void registerTable(ObservableList<Company> view){
        companyList = view;
    }

    public Stage getStage() {
        return this.stage;

    }

}
