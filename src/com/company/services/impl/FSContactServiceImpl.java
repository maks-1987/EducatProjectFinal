package com.company.services.impl;

import com.company.dao.ContactDao;
import com.company.model.Contact;
import com.company.services.ContactService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Реализация ContactService которая использует Файловую Систему для хранения данных.
 */
public class FSContactServiceImpl implements ContactService {

    private final ContactDao contactDao;
    ObservableList<Contact> list = FXCollections.observableArrayList();

    public FSContactServiceImpl(ContactDao contactDao) {
        this.contactDao = contactDao;
    }

    @Override
    public void createContact(String name, int age, String phoneNumber) {
        contactDao.saveContact(new Contact(name, age, phoneNumber));
        showContacts();
    }

    @Override
    public void deleteContact(String name) {
//        this.contactList.remove(name);
    }

   /* @Override
    public void showContacts() {
        contactDao.showAll();
//		for (Contact contact : this.contactList.values()) {
//			System.out.println(contact);
//		}
    }*/
   @Override
   public ObservableList<Contact> showContacts() {
       list.clear();
       list.addAll(contactDao.showAll());
       return list;
   }

    @Override
    public void editContact(String oldName, String newName, int newAge, String newPhoneNumber) {
//		Contact contact = this.contactList.get(name);
//		contact.setName(newName);
//		contact.setAge(newAge);
    }
}
