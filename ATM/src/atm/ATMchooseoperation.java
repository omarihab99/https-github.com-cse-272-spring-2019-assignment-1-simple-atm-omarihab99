package atm;


import atm.ATMEnteraccountnumber;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author omar_
 */
public class ATMchooseoperation {
    ATMEnteraccountnumber atmenteraccountnumber;
    Deposit deposit;
    ATMwithdraw atmwithdraw;
    ATMbalanceinquiry atmbalanceinquiry;
    Stage stage;
    Scene scene;
    int pointer =0;
    String[] history = new String[10];
    public ATMchooseoperation(Stage stage){
         this.stage=stage;
    }

    
    
    public void prepareScene(){
        Label chooseoperation = new Label();
        chooseoperation.setText("Choose your operation: ");
        Label historyy1 = new Label();
        Label historyy2 = new Label();
        Label historyy3 = new Label();
        Label historyy4 = new Label();
        Label historyy5 = new Label();
        historyy1.setText("");
        historyy2.setText("");
        historyy3.setText("");
        historyy4.setText("");
        historyy5.setText("");
         int i =-1; 
        Button dep = new Button();
        Button withdraw =  new Button();
        Button balanceinquiry = new Button();
        dep.setText("1-Deposit");
        withdraw.setText("2-Withdraw");
        balanceinquiry.setText("3-Balanceinquiry");
        GridPane grid = new GridPane();
        dep.setOnAction((ActionEvent event) -> {
           stage.setScene(deposit.getScene());
            });
        withdraw.setOnAction((ActionEvent event)->{
            stage.setScene(atmwithdraw.getScene());
        });
        balanceinquiry.setOnAction((ActionEvent event)->{
           stage.setScene(atmbalanceinquiry.getScene()); 
        });
        Button prev = new Button();
        prev.setText("4- Previous");
        Button next = new Button();
        next.setText("5- Next");
        Button logout = new Button();
        logout.setText("Logout");
        logout.setOnAction((ActionEvent event)->{
            stage.setScene(atmenteraccountnumber.getScene());
        });
        prev.setOnAction((ActionEvent event)->{
                pointer--;
            {   
                if(pointer!=-1){
                if(history[pointer]!=null){
                historyy1.setText(history[pointer]);
            }}
            else
            {   
                historyy1.setText("You dont have any more history");
            }
            }

            });
        next.setOnAction((ActionEvent event)->{
            pointer++;
            {
                if(history[pointer]!=null)
                {
                    historyy1.setText(history[pointer]);
                }
                else
                {
                    historyy1.setText("You dont have more history");
                }
            }
        });
        
        grid.add(chooseoperation,0,0);
        grid.add(dep, 0, 1);
        grid.add(withdraw,0,2);
        grid.add(balanceinquiry,0,3);
        grid.add(prev,0,4);
        grid.add(next,0,5);
        grid.add(logout,0,6);
        grid.add(historyy1,0,7);
        grid.add(historyy2,0,8);
        scene = new Scene(grid,700,400);
    }
    public void setScene(Scene scene){
        this.scene = scene;
    }
    public Scene getScene(){
        return scene;
    }
    public void setATMEnteraccountnumber(ATMEnteraccountnumber atmenteraccountnumber)
    {
        this.atmenteraccountnumber = atmenteraccountnumber;
    }
    public void setDeposit(Deposit deposit)
    {
        this.deposit= deposit;
    }
    public void setATMwithdraw(ATMwithdraw atmwithdraw)
    {
        this.atmwithdraw= atmwithdraw;
    }
    public void setATMbalanceinquiry(ATMbalanceinquiry atmbalanceinquiry)
    {
        this.atmbalanceinquiry= atmbalanceinquiry;
    }

    public String[] getHistory()
    {
        return history;
    }
    public void setHistory(String[] history)
    {
        this.history=history;
    }
    public int getPointer()
    {
        return pointer;
    }
    public void setPointer(int pointer)
    {
        this.pointer=pointer;
    }

   

   
}
   
    

    
