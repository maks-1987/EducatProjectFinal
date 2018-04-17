package com.company.dao.impl;

import com.company.dao.ContactDao;
import com.company.model.Contact;

import java.io.*;

public class FileSystemContactDaoImpl implements ContactDao {
    /**
     * Servis raboti s file system. Preobrazuet modeli v/iz dannie, hranimie na
     * zhestkom disc
     */
    private static final File FILE = new File("data");

    public FileSystemContactDaoImpl() {
    }

    //TODO исправить логику такб чтобы файл не пересоздавался, а дополнялся
    @Override
    public void saveContact(Contact contact) {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(
                new FileWriter(FILE)))) {
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
    public void showAll() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
