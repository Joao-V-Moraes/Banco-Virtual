package com.example.bancovirtual;

import com.example.bancovirtual.Account.BaseAccount;
import com.example.bancovirtual.Account.BaseUser;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.ArrayList;

public class HelloApplication extends Application {
    public static ArrayList<BaseUser> users = new ArrayList<>();
    public static ArrayList<BaseAccount> accounts = new ArrayList<>();

    public static BaseUser loggedUser;
    public static BaseAccount loggedAccount;

    @Override
    public void start(Stage stage) {
        try {
            Parent pane = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
            //Scene scene = new Scene(fxmlLoader.load(), 320, 240);
            stage.getIcons().add(new Image("file:D:\\Faculdade\\Códigos\\Java\\BancoVirtual\\src\\main\\resources\\com\\example\\bancovirtual\\image\\bank2.png"));
            stage.setTitle("Steel Bank");
            stage.setScene(new Scene(pane, 600, 400));
            stage.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //User.creatUserFile();
        launch(args);
    }
}