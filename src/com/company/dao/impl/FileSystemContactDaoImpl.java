package com.company.dao.impl;

import com.company.dao.ContactDao;
import com.company.model.Contact;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileSystemContactDaoImpl implements ContactDao {
    /**
     * Servis raboti s file system. Preobrazuet modeli v/iz dannie, hranimie na
     * zhestkom disc
     */
    private static final File FILE = new File("data");
   // private List<Contact> currentContact = new ArrayList<>();

    public FileSystemContactDaoImpl() {
    }

    //TODO файл дополняется
    @Override
    public void saveContact(Contact contact) {
        try (PrintWriter writer = new PrintWriter(
                new BufferedWriter(new FileWriter(FILE, true)))) {
            writer.println(contact);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeContact() {

    }

    @Override
    public List<Contact> showAll() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            return new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    /*//файл не пересоздается, а дополнялся новыми данными
    @Override
    public void saveContact(Contact contact) {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(
                new FileWriter(FILE, true)))) { // append - продолж запись данных
            writer.println(contact);                    // значение true-пишет вконец,
            writer.flush();                             // false-пишет вначало
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeContact() {
        *//*for (int i = 0; i < currentContact.size(); i++) {
            Contact removeContact = currentContact.get(i);
            Contact.class.getField(surName);
            if (removeContact.getSurName().equals(surName)) {
                currentContact.remove(i);
            }
        }*//*
    }

    @Override
    public void showAll() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
}
