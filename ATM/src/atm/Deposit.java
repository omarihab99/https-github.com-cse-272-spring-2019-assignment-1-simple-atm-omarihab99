package atm;


import static java.lang.Double.parseDouble;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import sun.misc.FloatingDecimal;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author omar_
 */
public class Deposit {
    Scene scene;
    ATMchooseoperation atmchooseoperation;
    ATMEnteraccountnumber atmenteraccountnumber;
    Stage stage;
     projectlogic logic;
     String[] history= new String[100];
     int pointer;
    
    public Deposit(Stage stage){
        this.stage=stage;
    }
    public void prepareScene(){
        logic = new projectlogic();
        Label depositlabel = new Label();
        depositlabel.setText("Enter the amount you want to deposit: ");
        TextField depositamount = new TextField();
        Button submit = new Button();
        Label opdone = new Label();
        Button logout =  new Button();
        
        
        Button prev =  new Button();
        logout.setText("Logout");
        submit.setText("Submit");
        prev.setText("Previous");
        
        
        submit.setOnAction((ActionEvent event)->  {
            String b ="";
            String amount = depositamount.getText();
            double amount1 = Double.valueOf(amount);
            double bal=logic.deposit(amount1);
            pointer = atmchooseoperation.getPointer();
            history = atmchooseoperation.getHistory();
            logic.setBalance(bal);
            history[pointer]="You deposited" + amount1;
                                    pointer++;

            atmchooseoperation.setHistory(history);
            atmchooseoperation.setPointer(pointer);

            System.out.println("balance= "+bal);
           
               atmchooseoperation.getHistory();
               System.out.println(history[pointer]);
            
            opdone.setText("Your operation has done and Your current balance=  " + bal);
            
    });
        logout.setOnAction((ActionEvent event)->{
                        stage.setScene(atmenteraccountnumber.getScene());
        });
        prev.setOnAction((ActionEvent event)->{
            stage.setScene(atmchooseoperation.getScene());
        });
        GridPane grid = new GridPane();
        grid.add(depositlabel,0,0);
        grid.add(depositamount,0,3);
        grid.add(submit,0,4);
        grid.add(opdone,0,7);
        grid.add(logout,0,5);
        grid.add(prev,0,6);
        
        scene = new Scene(grid,700,400);
    }
    public void setScene(Scene scene){
        this.scene = scene;
    }
    public Scene getScene(){
        return scene;
    }
    public void setATMchooseoperation(ATMchooseoperation chooseoperation){
        this.atmchooseoperation= chooseoperation;
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
