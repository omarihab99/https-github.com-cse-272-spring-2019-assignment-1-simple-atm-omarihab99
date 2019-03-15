package atm;


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
public class ATMwithdraw {
    Scene scene;
    ATMchooseoperation atmchooseoperation;
    Stage stage;
    projectlogic balance;
    projectlogic logic;
    int pointer;
    String[] history = new String[10];
    ATMEnteraccountnumber atmenteraccountnumber;
    public ATMwithdraw(Stage stage){
        this.stage= stage;
    }

    
    public void prepareScene(){
        logic =  new projectlogic();
        balance =  new projectlogic();
        Label withdrawlabel = new Label();
        Label historylabel =  new Label();
        historylabel.setText("");
        Label validlabel = new Label();
        Label opdone =  new Label();
        withdrawlabel.setText("Enter the amount you want to withdraw: ");
        TextField withdrawamount = new TextField();
        Button logout = new Button();
        Button submit = new Button();
        Button prev= new Button();
        prev.setText("Previous");
        submit.setText("Submit");
        logout.setText("Logout");
        submit.setOnAction((ActionEvent event)->{
                String amount = withdrawamount.getText();
                double amount1=Double.valueOf(amount);
                pointer = atmchooseoperation.getPointer();
                history = atmchooseoperation.getHistory();
                history[pointer]="You withdrawed" + amount1;
                                                pointer++;

                atmchooseoperation.setHistory(history);
                atmchooseoperation.setPointer(pointer);

                boolean valid= logic.withdrawvalid(amount1);
                if(valid)
                {
                    double bal=logic.withdraw(amount1);
                    logic.setBalance(bal);
                    System.out.println("balance= "+bal);
                    
                    opdone.setText("Your operation has done and Your current balance=  " + bal);
                    
                }
                else
                {
                    validlabel.setText("Invalid!\n your balance is less than the amount you want to withdraw");
                }
        });
        logout.setOnAction((ActionEvent event)->{
            stage.setScene(atmenteraccountnumber.getScene());
        });
        prev.setOnAction((ActionEvent event)->{
           stage.setScene(atmchooseoperation.getScene()); 
        });    
            
        
        GridPane grid = new GridPane();
        grid.add(withdrawlabel,0,0);
        grid.add(withdrawamount,0,3);
        grid.add(logout,0,8);
        grid.add(validlabel,2,4);
        grid.add(opdone,0,4);
        grid.add(submit,0,6);
        grid.add(prev,0,7);
        scene = new Scene(grid,700,400);
    }
    public void setScene(Scene scene){
        this.scene = scene;
        
    }
    public Scene getScene(){
        return scene;
    }
    public void setATMchooseoperation(ATMchooseoperation atmchooseoperation){
        this.atmchooseoperation= atmchooseoperation;
    }
    public void setATMEnteraccountnumber(ATMEnteraccountnumber atmenteraccountnumber)
    {
        this.atmenteraccountnumber=atmenteraccountnumber;
    }
    public projectlogic getBalance()
   {
       return logic;
   }
   public void setBalance(projectlogic logic)
   {
       this.logic=logic;
   }
   
   
}
