package com.marcus.mydb;

import com.marcus.mydb.forms.AddCompanyForm;
import com.marcus.mydb.model.Company;
import com.marcus.mydb.repository.CompanyRepository;
import com.marcus.mydb.repository.RepositoryFactory;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.List;

/**
 * @author marcus
 */
public class DbApp extends Application {

    private TableView table = new TableView();
    ObservableList<Company> ol;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Scene scene = new Scene(new Group());


        stage.setTitle("Table View Sample");
        stage.setWidth(500);
        stage.setHeight(500);

        final Button addCompanyBtn = new Button();
        addCompanyBtn.setText("Add Company");
        addCompanyBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

                AddCompanyForm addCompanyForm= new  AddCompanyForm();
                addCompanyForm.registerTable(ol);
                addCompanyForm.getStage().showAndWait();
            }
        });

        final Label label = new Label("Company maintenance");
        label.setFont(new Font("Arial", 20));

        table.setEditable(true);
        table.setPrefWidth(400);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        TableColumn startdate = new TableColumn("Start Date");
        TableColumn name = new TableColumn("Name");
        TableColumn postcode = new TableColumn("Postcode");
        TableColumn id = new TableColumn("id");


        id.setCellValueFactory(
                new PropertyValueFactory<Company, String>("id")
        );


        name.setCellValueFactory(
                new PropertyValueFactory<Company, String>("name")
        );
        postcode.setCellValueFactory(
                new PropertyValueFactory<Company, String>("postcode")
        );

        startdate.setCellValueFactory(
                new PropertyValueFactory<Company, String>("startdate")
        );

        ol = getData();
        table.setItems(ol);
        table.getColumns().addAll(id, name, postcode, startdate);


        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(label, addCompanyBtn, table);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();
    }


    private ObservableList<Company> getData() {

        CompanyRepository repo = RepositoryFactory.getCompanyRepository();
        List<Company> companies = repo.getAll();
        return FXCollections.observableArrayList(companies);

    }

}
