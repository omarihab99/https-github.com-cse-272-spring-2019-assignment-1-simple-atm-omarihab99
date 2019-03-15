/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 *
 * @author omar_
 */ public class ATMEnteraccountnumber{
     Scene scene;
     Stage stage;
     ATMchooseoperation Atmchooseoperation;
     accnumberauthentication authentication;
    public ATMEnteraccountnumber(Stage stage)
    {
        this.stage=stage;
    }
    
     
     
    public void prepareScene(){
        authentication = new accnumberauthentication();
        Label accountnumberlabel= new Label("Enter your account number: ");
        TextField accountnumberfield = new TextField();
        Button submit= new Button("Submit");
        Label validationlabel = new Label();
        GridPane grid = new GridPane();
        grid.add(accountnumberlabel,0,0);
        grid.add(accountnumberfield,1,0);
        grid.add(submit,1,2);
        grid.add(validationlabel,0,3);
        submit.setOnAction(new EventHandler<ActionEvent>(){
            
            @Override
            public void handle(ActionEvent event){
                String accountnumber= accountnumberfield.getText();
                boolean validation= authentication.validate(accountnumber);
                if(validation)
                {
                    validationlabel.setText("Welcome!");
                    stage.setScene(Atmchooseoperation.getScene());
                }
                else
                {
                    validationlabel.setText("Invalid");
                }
                
        
            }
        });
        scene=  new Scene(grid,700,400);
    }
    public Scene getScene()
    {
        return this.scene;
    }
    

    public void setATMchooseoperation(ATMchooseoperation Atmchooseoperation) {
        this.Atmchooseoperation=Atmchooseoperation;
    }

    
    
   
       
       
 }      
        
                

    
                         
    
   
    

