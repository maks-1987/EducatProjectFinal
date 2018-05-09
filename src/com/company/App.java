package com.company;

import com.company.dao.ContactDao;
import com.company.dao.impl.DBContactDAO;
import com.company.services.ContactService;
import com.company.services.impl.FSContactServiceImpl;
import com.company.view.CmdLineService;
import com.company.view.impl.CmdLineServiceImpl;

import java.io.IOException;

public class App {
    /**
     * Начало программы. Тут запускается программа, создаются все сервиса и устанавливаются связи между ними.
     */

    public static void main(String[] args) throws IOException {

        ContactDao contactDao = new DBContactDAO();

        ContactService contactService = new FSContactServiceImpl(contactDao);

        CmdLineService cmd = new CmdLineServiceImpl(contactService);

        cmd.runMenu();
    }

}
