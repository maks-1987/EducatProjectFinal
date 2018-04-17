package com.company.services.impl;

import com.company.model.Contact;
import com.company.services.ContactService;

import java.util.HashMap;
import java.util.Map;
/**
 * Реализация ContactService, которая использует Map для хранения данных.
 */
public class ContactServiceImpl implements ContactService {

    private Map<String, Contact> contactList;

    public ContactServiceImpl() {
        this.contactList = new HashMap<>();
    }

    @Override
    public void createContact(String name, int age, String phoneNumber) {
        this.contactList.put(name, new Contact(name, age, phoneNumber));
    }

    @Override
    public void deleteContact(String name) {
        contactList.remove(name);
    }

    @Override
    public void showContacts() {
        for (Contact contact : contactList.values()) {
            System.out.println(contact);
        }
    }

    @Override
    public void editContact(String oldName, String newName, int newAge, String newPhoneNumber) {
        Contact contact = contactList.get(oldName);
        contact.setName(newName);
        contact.setAge(newAge);
        contact.setPhoneNumber(newPhoneNumber);
    }

}
