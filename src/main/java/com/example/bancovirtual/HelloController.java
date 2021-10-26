package com.example.bancovirtual;

import com.example.bancovirtual.Account.BaseUser;
import com.example.bancovirtual.Account.Client;
import com.example.bancovirtual.Account.SimpleAccount;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloController {
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
    private Label currentAccount;
    @FXML
    private Label currentBalance;

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
        System.out.println(HelloApplication.loggedUser.getUsername());
        System.out.println(HelloApplication.loggedUser.getPassword());
        System.out.println(HelloApplication.loggedUser.getNumber());
        System.out.println(HelloApplication.loggedUser.getUserType());
        System.out.println(HelloApplication.loggedUser);
        System.out.println("o");
        HelloApplication.accounts.add(new SimpleAccount(HelloApplication.loggedUser.getNumber()));
        if(HelloApplication.accounts != null){
            lblStatus.setText("Conta simples criada!");
        }

    }
    @FXML
    protected void creatUser(){

        setUsername(tUser.getText());
        setPassword(tPassword.getText());
        setNumber(numAccount.getText());

        HelloApplication.users.add(new Client(username,password,number));
        //HelloApplication.loggedUser.getAccounts().add(new SimpleAccount(number));
        if(HelloApplication.users == null)
            lblStatus.setText("A conta não foi criada");
        else{
            lblStatus.setText("Conta criada com sucesso !!");
        }
        for(int i= 0; i < HelloApplication.users.size(); i++){
            BaseUser client = HelloApplication.users.get(i);
            System.out.println(client.getUsername());
            System.out.println(client.getPassword());
            System.out.println(client.getNumber());
            System.out.println(client.getUserType());
            }
        System.out.println(HelloApplication.users);


        //HelloApplication.loggedUser.getAccounts().add(new SimpleAccount(number));
//        if(HelloApplication.loggedUser.getUserType() == "Cliente"){
//
//        }else{
//
//        }
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