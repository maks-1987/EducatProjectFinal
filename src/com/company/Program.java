package com.company;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Program  extends Application {

    /**
     * Тут прога запускается. Создаются экземпляры всех нужных интерфейсов, которые написаны
     * в этой проге и все сервисы, для связи между ними.
     */
    public static void main(String[] args) throws IOException {
        launch();
    }

//	@FXML
//	public void initialize() {
//		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
//		ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
//
//		tableView.setItems(contactService.showContacts());
//	}
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
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view/scenes/mainScene.fxml"));
        primaryStage.setTitle("Contact Book");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    //	@FXML
//	public void initialize() {
//		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
//		ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
//
//		tableView.setItems(contactService.showContacts());
//	}
}

