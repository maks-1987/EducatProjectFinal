package com.company.services.impl;

import com.company.model.Contact;
import com.company.services.ContactService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
/**
 * Реализация ContactService, которая использует Map для хранения данных.
 */
public class ContactServiceImpl implements ContactService {

    //private Map<String, Contact> contactList;

    private final ObservableList<Contact> contactList;

    public ContactServiceImpl() {
        this.contactList = FXCollections.observableArrayList();
    }

    @Override
    public void createContact(String name, int age, String phoneNumber) {
        this.contactList.add(new Contact(name, age, phoneNumber));
    }

    @Override
    public void deleteContact(String name) {
//        contactList.remove(name);
    }

/*  @Override
    public void showContacts() {
        for (Contact contact : contactList.values()) {
            System.out.println(contact);
        }
    }*/
    @Override
    public ObservableList<Contact> showContacts() {
    return contactList;
}

    @Override
    public void editContact(String oldName, String newName, int newAge, String newPhoneNumber) {
//        Contact contact = contactList.get(oldName);
//        contact.setName(newName);
//        contact.setAge(newAge);
//        contact.setPhoneNumber(newPhoneNumber);
    }

}
