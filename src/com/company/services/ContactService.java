package com.company.services;

import com.company.model.Contact;
import javafx.collections.ObservableList;

/**
 * Сервис бизнес логики, который описывает основные действия над доменными
 * моделями - Контактами.
 */
public interface ContactService {

    void createContact(String name, int age, String phoneNumber);
    void deleteContact(String name);
    ObservableList<Contact> showContacts();
    void editContact(String oldName, String newName, int newAge, String newPhoneNumber);

}
