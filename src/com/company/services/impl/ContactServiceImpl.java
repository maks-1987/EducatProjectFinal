package com.company.services.impl;

import com.company.model.Contact;
import com.company.services.ContactService;
import com.company.services.Valid;

import java.util.HashMap;
import java.util.Map;

public class ContactServiceImpl implements ContactService {
    private Map<String, Contact> contactList = new HashMap<>();

    @Override
    public void createContact(String name, int age, String phoneNumber) {
        this.contactList.put(name, new Contact(name, age, phoneNumber));
    }

    @Override
    public void deleteContact(String name) {
        this.contactList.remove(name);
    }
    /*@Override
        public void deleteContact() throws IOException, IndexOutOfBoundsException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(" Deleting a contact by index (0 - ...) N_ ");
            int index = Integer.parseInt(br.readLine());
            try {
                if (index >= 0) {
                    contactList.remove(index);
                    System.out.println("Contact deleted");
                } else { // если число < 0 выведем это:
                    System.out.println(" Incorrect index. Repeat! Delete Contact");
                } // если ввести число > чем индексов массива выведем это:
            } catch (IndexOutOfBoundsException e) {
                System.out.println(" Incorrect index. Repeat! Delete Contact");
            }  }*/
    @Valid
    @Override
    public void showContact() {
        for (Contact contact : this.contactList.values()) {
            System.out.println(contact);
        }
        /*if (contactList.isEmpty()) { // проверка, пустой ли список
            System.out.println(" ContactList is Empty! ");
        } else { // если не пустой, выводим контакты построчно
            for (int i = 0; i < contactList.size(); i++) {
                int j = contactList.size() - i - 1; // (arr.length - 1 - 0 = 0, потом 1,2...)
                System.out.println(contactList.get(j));
            }
        }*/
    }

    @Override
    public void editContact(String oldName, String newName, int newAge, String newPhoneNumber) {
        Contact contact = this.contactList.get(oldName);
        contact.setName(newName);
        contact.setAge(newAge);
        contact.setPhoneNumber(newPhoneNumber);
    }


}
