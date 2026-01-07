/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.question1project2;


import javafx.application.Application;
import javafx.collections.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/** Digital Insurance Management System – everything in one class for simplicity */
public class Question1Project2 extends Application {

  
    TextField  NameField     = new TextField();
    TextField  SurnameField  = new TextField();
    TextField  IdField       = new TextField();
    Spinner<Integer> AgeSpin = new Spinner<>(0, 120, 30);
    TextField  AddressField  = new TextField();
    ComboBox<String> policyComboBox = new ComboBox<>();
    ComboBox<String> sumInsuredComboBox = new ComboBox<>();
    TextField  CoverageField = new TextField();
    TextField  PremiumField  = new TextField();
    TableView<Policy> table  = new TableView<>();
    ObservableList<Policy> policies = FXCollections.observableArrayList();

    @Override
    public void start(Stage stage) {
       
        GridPane form = new GridPane();
        form.setHgap(10); form.setVgap(10); form.setPadding(new Insets(10));
        
         Text text1=new Text();
         text1.setText("Insurance Management system");
         text1.setFill(Color.BLUE);
         

        addRow(form, 0, "Customer Name:", NameField);
        addRow(form, 1, "Customer Surname:", SurnameField);
        addRow(form, 2, "ID Number:", IdField);
        addRow(form, 3, "Age:", AgeSpin);
        addRow(form, 4, "Address:", AddressField);

        policyComboBox.getItems().addAll("Life", "Health", "Auto");
        sumInsuredComboBox.getItems().addAll("R100 000", "R250 000", "R500 000", "R1 000 000");
        policyComboBox.getSelectionModel().selectFirst();
        sumInsuredComboBox.getSelectionModel().selectFirst();

        addRow(form, 5, "Policy Type:", policyComboBox);
        addRow(form, 6, "Sum Insured:", sumInsuredComboBox);
        addRow(form, 7, "Coverage Amount:", CoverageField);
        addRow(form, 8, "Premium Amount:", PremiumField);

        Button submitBtn = new Button("Submit");
        submitBtn.setOnAction(e -> handleSubmit());
        Button viewBtn   = new Button("View Policies");
        viewBtn.setOnAction(e -> table.requestFocus());

        HBox buttons = new HBox(10, submitBtn, viewBtn);
        VBox root = new VBox(15, form, buttons, buildTable());
        root.setPadding(new Insets(12));
        
        
        Scene scene=new Scene(root,800,600,Color.BLACK);

        stage.setScene(scene);
        stage.setTitle("Digital Insurance Management System");
        
        stage.show();
    }

    
    private void handleSubmit() {
        if (NameField.getText().isEmpty() || SurnameField.getText().isEmpty()) {
            alert("Name and surname required."); return;
        }
        try {
            double cov = Double.parseDouble(CoverageField.getText());
            double prem= Double.parseDouble(PremiumField.getText());
            policies.add(new Policy(
                    NameField.getText(), SurnameField.getText(),
                    policyComboBox.getValue(), sumInsuredComboBox.getValue(),
                    cov, prem));
            clearForm();
        } catch (NumberFormatException ex) {
            alert("Coverage and Premium must be numeric.");
        }
    }

    private TableView<Policy> buildTable() {
        TableColumn<Policy,String>  cName   = new TableColumn<>("Name");
        TableColumn<Policy,String>  cSName  = new TableColumn<>("Surname");
        TableColumn<Policy,String>  cType   = new TableColumn<>("Policy");
        TableColumn<Policy,String>  cSum    = new TableColumn<>("Sum Insured");
        TableColumn<Policy,Number>  cCov    = new TableColumn<>("Coverage");
        TableColumn<Policy,Number>  cPrem   = new TableColumn<>("Premium");

        cName.setCellValueFactory(p -> p.getValue().name);
        cSName.setCellValueFactory(p -> p.getValue().surname);
        cType.setCellValueFactory(p -> p.getValue().policyType);
        cSum.setCellValueFactory(p -> p.getValue().sumInsured);
        cCov.setCellValueFactory(p -> p.getValue().coverage);
        cPrem.setCellValueFactory(p -> p.getValue().premium);

        
       
        table.getColumns().addAll(cName, cSName, cType, cSum, cCov, cPrem);
        table.setItems(policies);
        table.setPrefHeight(250);
        return table;
    }

    private void clearForm() {
        NameField.clear(); SurnameField.clear(); IdField.clear(); AddressField.clear();
        CoverageField.clear(); PremiumField.clear();
        AgeSpin.getValueFactory().setValue(30);
        policyComboBox.getSelectionModel().selectFirst();
        sumInsuredComboBox.getSelectionModel().selectFirst();
    }

    private void alert(String msg) {
        new Alert(Alert.AlertType.WARNING, msg, ButtonType.OK).showAndWait();
    }

    private static void addRow(GridPane gp, int row, String label, Control field) {
        gp.addRow(row, new Label(label), field);
    }

   
    public static class Policy {
   javafx.beans.property.StringProperty name       = new javafx.beans.property.SimpleStringProperty();
   javafx.beans.property.StringProperty surname    = new javafx.beans.property.SimpleStringProperty();
   javafx.beans.property.StringProperty policyType = new javafx.beans.property.SimpleStringProperty();
   javafx.beans.property.StringProperty sumInsured = new javafx.beans.property.SimpleStringProperty();
   javafx.beans.property.DoubleProperty coverage   = new javafx.beans.property.SimpleDoubleProperty();
   javafx.beans.property.DoubleProperty premium    = new javafx.beans.property.SimpleDoubleProperty();

        public Policy(String n, String s, String t, String sum, double cov, double prem) {
            name.set(n); surname.set(s); policyType.set(t); sumInsured.set(sum);
            coverage.set(cov); premium.set(prem);
        }
    }

    public static void main(String[] args) { 
        
        
        
       Application.launch(args);
    
    
    }
}        
  