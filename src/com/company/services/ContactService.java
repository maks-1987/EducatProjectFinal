package com.company.services;

/**
 * Сервис бизнес логики, который описывает основные действия над доменными
 * моделями - Контактами.
 */
public interface ContactService {

    void createContact(String name, int age, String phoneNumber);
    void deleteContact(String name);
    void showContacts();
    void editContact(String oldName, String newName, int newAge, String newPhoneNumber);

}
