package atm;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author omar_
 */
public class accnumberauthentication {
    public boolean validate(String accountnumber)
    {
         
         String an= "123";
        if(an.equals(accountnumber)){
            return  true;
        }
        else{
            return  false;
        }
        }
    
    
}
