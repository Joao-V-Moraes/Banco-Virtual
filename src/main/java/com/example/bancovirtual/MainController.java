package com.example.bancovirtual;

import com.example.bancovirtual.Account.*;
import javafx.beans.binding.When;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;

public class MainController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    private String username;
    private String password;
    private String number;

    private float balance;
    private int cont;

    @FXML
    private Label lblStatus;
    @FXML
    private Label lblStatus1;
    @FXML
    private Label lblStatus2;
    @FXML
    private Label lblStatus3;

    @FXML
    private TextField userLogin;

    @FXML
    private PasswordField passwordLogin;


    @FXML
    private TextField tUser;
    @FXML
    private PasswordField tPassword;
    @FXML
    private PasswordField numAccount;

    @FXML
    private TextField tDeposit;
    @FXML
    private Label currentAccount;
    @FXML
    private Label currentBalance;
    @FXML
    private ListView ex;

    public MainController() {
    }


    public void mainScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void loginScene(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("login-view.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void newUserScene(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("user-view.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void login(ActionEvent eventLogin) {
        String inputU;
        String inputP;

        for(BaseUser user : HelloApplication.users){
            inputU = userLogin.getText();
            inputP = passwordLogin.getText();
            System.out.println(inputU);
            System.out.println(inputP);

            if(user.getUsername().equals(inputU) && user.getPassword().equals(inputP)){
                lblStatus.setText("Login feito com sucesso");
                HelloApplication.loggedUser = user;
                try {
                    loginScene(eventLogin);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else{
                lblStatus.setText("Usuário/senha incorreto(a)");
            }
        }
    }

    public void creatSimple(ActionEvent event){
//        System.out.println(HelloApplication.loggedUser.getUsername());
//        System.out.println(HelloApplication.loggedUser.getPassword());
//        System.out.println(HelloApplication.loggedUser.getNumber());
//        System.out.println(HelloApplication.loggedUser.getUserType());
//        System.out.println(HelloApplication.loggedUser);
        setNumber(HelloApplication.loggedUser.getNumber());
        HelloApplication.accounts.add(new SimpleAccount(number));
        for(BaseAccount account : HelloApplication.accounts){
            if(account.getNumber().equals(number)){
                HelloApplication.loggedAccount = account;
            }

        }



        if(HelloApplication.accounts != null){
            lblStatus.setText("Conta simples criada!");
            lblStatus3.setText("Conta atual: Simples");
        }

    }

    public void creatSpecial(ActionEvent event){
//        System.out.println(HelloApplication.loggedUser.getUsername());
//        System.out.println(HelloApplication.loggedUser.getPassword());
//        System.out.println(HelloApplication.loggedUser.getNumber());
//        System.out.println(HelloApplication.loggedUser.getUserType());
//        System.out.println(HelloApplication.loggedUser);
        HelloApplication.accounts.add(new SpecialAccount(HelloApplication.loggedUser.getNumber()));
        if(HelloApplication.accounts != null){
            lblStatus1.setText("Conta Especial criada!");
            lblStatus3.setText("Conta atual: Especial");
            //System.out.println(HelloApplication.loggedAccount.getNumber());
           // HelloApplication.loggedAccount.getAccountType();

        }
    }

    public void creatSavings(ActionEvent event){
//        System.out.println(HelloApplication.loggedUser.getUsername());
//        System.out.println(HelloApplication.loggedUser.getPassword());
//        System.out.println(HelloApplication.loggedUser.getNumber());
//        System.out.println(HelloApplication.loggedUser.getUserType());
//        System.out.println(HelloApplication.loggedUser);
        HelloApplication.accounts.add(new SavingsAccount(HelloApplication.loggedUser.getNumber()));
        if(HelloApplication.accounts != null){
            lblStatus2.setText("Conta Poupança criada!");
            lblStatus3.setText("Conta atual: Poupança");
        }
    }

    public void creatUser(){

        setUsername(tUser.getText());
        setPassword(tPassword.getText());
        setNumber(numAccount.getText());


        //HelloApplication.loggedUser.getAccounts().add(new SimpleAccount(number));
        if(username != "" && password != "" && number != "") {
            HelloApplication.users.add(new Client(username, password, number));
            lblStatus.setText("Usuário criado com sucesso !!");
        }

//        for(int i= 0; i < HelloApplication.users.size(); i++){
//            BaseUser client = HelloApplication.users.get(i);
//            System.out.println(client.getUsername());
//            System.out.println(client.getPassword());
//            System.out.println(client.getNumber());
//            System.out.println(client.getUserType());
//            }
        System.out.println(HelloApplication.users);

        //HelloApplication.loggedUser.getAccounts().add(new SimpleAccount(number));
//        if(HelloApplication.loggedUser.getUserType() == "Cliente"){
//
//        }else{
//
//        }
    }

    public void deposit(){
        float f = Float.parseFloat(tDeposit.getText());
        HelloApplication.loggedAccount.setBalance(f);
        System.out.println(HelloApplication.loggedAccount.getBalance());
        currentAccount.setText(HelloApplication.loggedUser.getUserType());

    }

    public void extrac(){
        ListView<String> list = new ListView<String>();
        ObservableList<String> items = FXCollections.observableArrayList ("Single", "Double", "Suite", "Family App");
        list.setItems(items);
    }


    public void setBalance(float balance) {
        this.balance = balance;
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}