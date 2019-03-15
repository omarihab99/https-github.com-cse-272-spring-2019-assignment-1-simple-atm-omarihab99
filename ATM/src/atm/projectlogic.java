/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

/**
 *
 * @author omar_
 */
public class projectlogic {

    private static double balance =4000;
    boolean withdrawvalid(double withdraw)
    {
        if(withdraw<=balance)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    double withdraw(double amountwd)
    {
        if(amountwd<=balance)
        {
            balance= balance-amountwd;
            return balance;
        }
        else
        {
            return balance;
        }
    }
    
    double deposit(double amountdep)
    {
        balance=balance+amountdep;
        return balance;
    }
    public  static void setBalance(double balance)
    {
        projectlogic.balance= balance;
    }
    public double getBalance(double amount2)
    {
        return balance;
    }
    double balanceinquiry(double amount)
    {
        this.balance = amount;
        return balance;
    }

    

   
    
        
            
    
}
