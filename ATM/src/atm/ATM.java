package atm;

import javafx.application.Application;
import javafx.stage.Stage;
public class ATM extends Application
{
   
    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("ATM");
        
        ATMEnteraccountnumber atmenteraccountnumber = new ATMEnteraccountnumber(primaryStage);
        atmenteraccountnumber.prepareScene();
        
        ATMchooseoperation atmchooseoperation = new ATMchooseoperation(primaryStage);
        atmchooseoperation.prepareScene();
        
        Deposit deposit = new Deposit(primaryStage);
        deposit.prepareScene();
        
        ATMwithdraw atmwithdraw= new ATMwithdraw(primaryStage);
        atmwithdraw.prepareScene();
        
        ATMbalanceinquiry atmbalanceinquiry = new ATMbalanceinquiry(primaryStage);
        atmbalanceinquiry.prepareScene();
        
        
        
        atmenteraccountnumber.setATMchooseoperation(atmchooseoperation);
        atmchooseoperation.setDeposit(deposit);
        atmchooseoperation.setATMwithdraw(atmwithdraw);
        atmchooseoperation.setATMbalanceinquiry(atmbalanceinquiry);
        atmbalanceinquiry.setATMchooseoperation(atmchooseoperation);
        atmchooseoperation.setATMbalanceinquiry(atmbalanceinquiry);
        atmchooseoperation.setATMEnteraccountnumber(atmenteraccountnumber);
        atmwithdraw.setATMEnteraccountnumber(atmenteraccountnumber);
        atmwithdraw.setATMchooseoperation(atmchooseoperation);
        atmbalanceinquiry.setATMEnteraccountnumber(atmenteraccountnumber);
        deposit.setATMEnteraccountnumber(atmenteraccountnumber);
        deposit.setATMchooseoperation(atmchooseoperation);
        primaryStage.setScene(atmenteraccountnumber.getScene());
        primaryStage.show();
    
    }

public static void main(String[] args, double balance) {
        launch(args);
        
    }
    
}


   

    

   

    


