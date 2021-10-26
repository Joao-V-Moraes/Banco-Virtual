package com.example.bancovirtual;

import com.example.bancovirtual.Account.*;
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


public class MainController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    private String username;
    private String password;
    private String number;

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
    private TextField tWithdraw;

    @FXML
    private Label currentAccount;
    @FXML
    private Label currentBalance;
    @FXML
    private Label wCurrentAccount;
    @FXML
    private Label wCurrentBalance;
    @FXML
    private Label ex;
    @FXML
    private  Label ex1;

    public MainController() {
    }


    public void mainScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
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
        HelloApplication.accounts.add(new SpecialAccount(HelloApplication.loggedUser.getNumber()));
        if(HelloApplication.accounts != null){
            lblStatus1.setText("Conta Especial criada!");
            lblStatus3.setText("Conta atual: Especial");
        }
    }

    public void creatSavings(ActionEvent event){
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
        if(username != "" && password != "" && number != "") {
            HelloApplication.users.add(new Client(username, password, number));
            lblStatus.setText("Usuário criado com sucesso !!");
        }
    }

    public void deposit(){
        float f = Float.parseFloat(tDeposit.getText());
        f = HelloApplication.loggedAccount.getBalance() + f;
        HelloApplication.loggedAccount.setBalance(f);
        String s = String.valueOf(HelloApplication.loggedAccount.getBalance());
        currentBalance.setText(s);
        ex.setText("Depositou: " + f);
        currentAccount.setText(HelloApplication.loggedAccount.getAccountType());
    }

    public void withdraw(){
        if(HelloApplication.loggedAccount.getBalance() > 0) {
            float f = Float.parseFloat(tWithdraw.getText());
            f = HelloApplication.loggedAccount.getBalance() - f;
            HelloApplication.loggedAccount.setBalance(f);
            String s = String.valueOf(HelloApplication.loggedAccount.getBalance());
            wCurrentBalance.setText(s);
            ex1.setText("Retirou: " + f);
            wCurrentAccount.setText(HelloApplication.loggedAccount.getAccountType());
        }else{
            wCurrentBalance.setText("Saldo insuficiente");
        }
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNumber(String number) {
        this.number = number;
    }

}