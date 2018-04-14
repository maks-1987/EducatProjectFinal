package com.company.services;

public interface ContactService {

    void createContact(String name, int age, String phoneNumber);
    void deleteContact(String name);
    void showContact();
    void editContact(String oldName, String newName, int newAge, String newPhoneNumber);

}
