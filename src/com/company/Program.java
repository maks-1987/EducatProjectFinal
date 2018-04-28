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
     * Тут прога запускается. Создаются экземпляры всех нужных интерфейсов, которые написаны
     * в этой проге и все сервисы, для связи между ними.
     */
    public static void main(String[] args) throws IOException {
        /*// Connection DB
        try {
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.getConnection("jdbc:h2:" + "./src/DB/myDB", "root", "root");
            Statement statement =  conn.createStatement();
            statement.execute("create table pawn(name varchar(20))");
            //statement.execute("create table users(name varchar(20))");
            System.out.println("create table");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

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

        //Neposredstvennij zapusk grafichesk interf i progi
        cmd.runMenu();


    }
}

