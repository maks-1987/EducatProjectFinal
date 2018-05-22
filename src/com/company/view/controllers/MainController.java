package com.company.view.controllers;

import com.company.dao.impl.DBContactDAO;
import com.company.model.Contact;
import com.company.services.ContactService;
import com.company.services.impl.FSContactServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainController {

    private ContactService contactService;
    @FXML
    private TextField inputName;
    @FXML
    private TextField inputAge;
    @FXML
    private TextField inputPhoneNumber;
    @FXML
    private Button createButton;
    @FXML
    private Button createButton2;
    @FXML
    private Button createButton3;
    @FXML
    private TableView<Contact> table;
    @FXML
    private TableColumn<Contact, String> nameColumn;
    @FXML
    private TableColumn<Contact, Integer> ageColumn;
    @FXML
    private TableColumn<Contact, String> phoneNumberColumn;

    public MainController() {
        this.contactService = new FSContactServiceImpl(new DBContactDAO());
    }

    public void createContact() {
        String name = inputName.getText();
        String age = inputAge.getText();
        String phoneNumber = inputPhoneNumber.getText();
        contactService.createContact(name, new Integer(age), new String(phoneNumber));
    }
    // TODO: implement method
    public void deleteContact() {
        String name = inputName.getText();
        String age = inputAge.getText();
        String phoneNumber = inputPhoneNumber.getText();
        contactService.createContact(name, new Integer(age), new String(phoneNumber));
    }
    // TODO: implement method
    public void editContact() {
        String name = inputName.getText();
        String age = inputAge.getText();
        String phoneNumber = inputPhoneNumber.getText();
        contactService.createContact(name, new Integer(age), new String(phoneNumber));
    }

    @FXML
    public void initialize() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        phoneNumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        table.setItems(contactService.showContacts());
    }
}
