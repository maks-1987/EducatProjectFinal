package com.company.view.impl;

import com.company.services.ContactService;
import com.company.view.CmdLineService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CmdLineServiceImpl implements CmdLineService {

    private ContactService contactService;
    private BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

    public CmdLineServiceImpl(ContactService contactService) {
        this.contactService = contactService;
    }

    private static void showMenu() {
        System.out.println("1. Create Contact");
        System.out.println("2. Delete Contact");
        System.out.println("3. Show Contact");
        System.out.println("4. Edit Contact");
        System.out.println("0. Exit");
    }

    @Override
    public void runMenu() throws IOException {
        boolean isRunning = true;
        while (isRunning) { // переменная ПРАВДА, цикл повтор всегда
            showMenu();
            String line = br.readLine();
            switch (line) {
                case "1": {
                    createContact();
                    break;
                }
                case "2": {
                    deleteContact();
                    break;
                }
                case "3": {
                    showContact();
                    break;
                }
                case "4": {
                    editContact();
                    break;
                }
                case "0": {
                    isRunning = false;
                    break;
                }
                default:
                    System.out.println("Repeat");
            }
        }
    }

    private void showContact() {
        this.contactService.showContact();
    }

    private void createContact() throws IOException {
        System.out.println("Enter name");
        String name = br.readLine();
        System.out.println("Enter age");
        //int ageN = readInt();
        int age = Integer.parseInt(br.readLine());
        System.out.println("Enter phoneNumber");
        String phoneNumber = br.readLine();
        this.contactService.createContact(name, age, phoneNumber);
    }

    private void deleteContact() throws IOException {
        System.out.println("Enter Name");
        String name = br.readLine();
        this.contactService.deleteContact(name);
    }
    private void editContact() throws IOException {
        System.out.println("Enter name of modified contact");
        String name = br.readLine();
        System.out.println("Enter new name");
        String newName = br.readLine();

        System.out.println("Enter age of modified contact");
        String age = br.readLine();
        System.out.println("Enter new age");
        int newAge = Integer.parseInt(br.readLine());

        System.out.println("Enter phoneNumber of modified contact");
        String phoneNumber = br.readLine();
        System.out.println("Enter new phone");
        String newPhoneNumber = br.readLine();
        this.contactService.editContact(name, newName, newAge, newPhoneNumber);
    }
    /*private int readInt() throws IOException {
        int i;
        try {
            System.out.println("Input number!");
            String line = this.br.readLine();
            i = new Integer(line);
        }
        catch (NumberFormatException ex) {
            System.out.println("Wrong Input!");
            return readInt();
        }
        return i;
    }*/

}
