package com.company.dao.impl;

import com.company.dao.ContactDao;
import com.company.model.Contact;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBContactDAO implements ContactDao {

    private static final String DB_URL = "jdbc:h2:tcp://localhost/~/Program";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public DBContactDAO() {
        try {
            Class.forName("org.h2.Driver");
        }
        catch (ClassNotFoundException e) {
            System.out.println("Can't connect to DB");
        }
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement st = connection.createStatement()) {
            st.execute("CREATE TABLE IF NOT  EXISTS CLIENT(ID INT AUTO_INCREMENT PRIMARY KEY, NAME VARCHAR(255), AGE INT);");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void saveContact(Contact contact) {
        try (Connection connection = DriverManager
                .getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement st = connection.prepareStatement("INSERT INTO CLIENT(NAME, AGE) VALUES(?, ?);")) {

            st.setString(1, contact.getName());
            st.setInt(2, contact.getAge());

            st.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeContact() {

    }

    @Override
    public List<Contact> showAll() {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             Statement st = connection.createStatement()) {
            List<Contact> clients = new ArrayList<>();
            try (ResultSet resultSet = st.executeQuery("SELECT * FROM CLIENT;")) {
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    int age = resultSet.getInt("age");
                    String phoneNumber = resultSet.getString("phoneNumber");
                    clients.add(new Contact(name, age, phoneNumber));
                }
            }
            return clients;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
