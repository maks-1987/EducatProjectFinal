package com.company;

import com.company.dao.ContactDao;
import com.company.dao.impl.FileSystemContactDaoImpl;
import com.company.services.ContactService;
import com.company.services.impl.FSContactServiceImpl;
import com.company.view.CmdLineService;
import com.company.view.impl.CmdLineServiceImpl;

import java.io.IOException;

public class Program {
/*public class Program extends Thread {
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
    }*/
    /**
     * Nachalo progi. Tut ona zapuskaetsa, sozdautsa vse servisi i ustanavliv svaz
     * mezdu nimi
     */
    public static void main(String[] args) throws IOException {
        // Sozdanie samogo niznego sloja servisov - DAO, kotor rabotaet so sredstvami
        // dolgosrochnogo hranenija info
        ContactDao contactDao = new FileSystemContactDaoImpl();

        // Sozdanie sloja servisov, kotorie hranjat biznes logic. Logic upravlenija
        // modeljami i t.d. Obichno eti servisi ispolzuut sloj DAO dla dolgosrochnogo
        // hranen dannih
        ContactService contactService = new FSContactServiceImpl(contactDao);

        // Sozdanie servisov sloja predstavlenia. Samie visokourovnrvie servisi,
        // kotorie upravlaut servisami biznes logic. Sloj otvechaushij za graf interf
        // i udobstvo raboti Polsovatela s progoj
        CmdLineService cmd = new CmdLineServiceImpl(contactService);

        //Neposredstvennij zapusk graf interf i progi
        cmd.runMenu();
    }
}

