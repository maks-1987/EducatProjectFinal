package com.company.dao;

import com.company.model.Contact;

import java.util.List;

public interface ContactDao {
    /**
     * Interface, opisivaushij osnovnoe poveden raboti s razlichnimi variantami
     * dolgosrochnogo hranenija dannih (fajlov sistem, baza dan, i t.d.)
     */
    void saveContact(Contact contact);

    void removeContact();

    List<Contact> showAll();
}
