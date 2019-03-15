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
public class ATMbalanceinquiry {
    Scene scene;
    ATMchooseoperation atmchooseoperation;
    ATMEnteraccountnumber aTMEnteraccountnumber;
    String[] history= new String[100];
     int pointer;
    Stage stage;
    projectlogic logic;
    public ATMbalanceinquiry(Stage stage){
        this.stage = stage;
        
    }
    
    
    public void prepareScene(){
        logic = new projectlogic();
        Label balanceinquirylabel = new Label();
        Button submit=  new Button();
        TextField balance = new TextField();
        submit.setText("Submit");
        Button logout = new Button();
        logout.setText("Logout");
        Button prev = new Button();
        prev.setText("Previous");
        prev.setOnAction((ActionEvent event)->{
            stage.setScene(atmchooseoperation.getScene());
            
            
        });
        submit.setOnAction((ActionEvent event)->{
            double b = 0 ;
            balanceinquirylabel.setText("Your current balance: " + logic.getBalance(b));
            pointer = atmchooseoperation.getPointer();
            history = atmchooseoperation.getHistory();
            history[pointer]="Balance inquiry" + logic.getBalance(b);
                                    pointer++;

            atmchooseoperation.setHistory(history);
            atmchooseoperation.setPointer(pointer);
            
        });
        logout.setOnAction((ActionEvent event)->{
            stage.setScene(aTMEnteraccountnumber.getScene());
        });
        GridPane grid = new GridPane();
        grid.add(balanceinquirylabel,0,0);
        grid.add(prev,0,1);
        grid.add(submit,0,2);
        grid.add(logout,0,3);
        scene= new Scene(grid,700,400);
    }
    public void setScene(Scene scene)
    {
        this.scene= scene;
    }
    public Scene getScene(){
        return scene;
    }
    public void setATMchooseoperation(ATMchooseoperation atmchooseoperation)
    {
        this.atmchooseoperation= atmchooseoperation;
    }
    
   public projectlogic getBalance()
   {
       return logic;
   }
   public void setBalance(projectlogic logic)
   {
       this.logic=logic;
   }

    void setATMEnteraccountnumber(ATMEnteraccountnumber atmenteraccountnumber) {
        this.aTMEnteraccountnumber=atmenteraccountnumber;
    }
}
