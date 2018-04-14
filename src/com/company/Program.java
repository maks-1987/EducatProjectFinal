package com.company;

import com.company.services.impl.ContactServiceImpl;
import com.company.view.CmdLineService;
import com.company.view.impl.CmdLineServiceImpl;

import java.io.IOException;

public class Program extends Thread {
    public static void main(String[] args) {
        new Program().start();

    }

    public void run() {
        System.out.println("\n" + "Prog running as Thread:" + "\n");
        CmdLineService cmd = new CmdLineServiceImpl(new ContactServiceImpl());
        try {
            cmd.runMenu();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

