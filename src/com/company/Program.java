package com.company;

import com.company.services.impl.ContactServiceImpl;
import com.company.view.CmdLineService;
import com.company.view.impl.CmdLineServiceImpl;

import java.io.IOException;

public class Program {

    public static void main(String[] args) throws IOException {
        CmdLineService cmd = new CmdLineServiceImpl(new ContactServiceImpl());
        cmd.runMenu();

    }

}

