/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ATM;

import java.util.Scanner;

/**
 *
 * @author kenny
 */
public class ATM {

    static FacadeATM atm;

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        atm = FacadeATM.getInstance();
        boolean exit = false;
        System.out.println("Welcome to the ATM Program");

        while (!exit) {
            /* exit condition for switch-case */

            System.out.println("Below are the options for you to choose from:\n"
                    + "1. Type BALANCE to check your Balance\n"
                    + "2. Type DEPOSIT to deposit money\n"
                    + "3. Type WITHDRAWAL to withdraw money\n"
                    + "4. Type EXIT to exit the program");
            /* Ask user for input */

            Scanner scan = new Scanner(System.in);
            String c = scan.nextLine();
            c = c.toUpperCase();

            switch (c) {
                case "BALANCE":
                    atm.balance();
                    break;

                case "DEPOSIT":
                    atm.deposit();
                    break;

                case "WITHDRAWAL":
                    atm.withdrawal();
                    break;

                case "EXIT":
                    while (true) {
                        System.out.println("Are you sure you want to exit?(YES/NO): ");
                        String answer = new Scanner(System.in).nextLine();
                        if(answer.toUpperCase().equals("YES")) {
                            exit = true;
                            break;
                        }else if(answer.toUpperCase().equals("NO")){
                            break;
                        }else{
                            System.out.println("ERROR: Please enter from available options");
                        }
                    }
                    break;

                default:
                    System.out.println("ERROR: Please enter from available options");
                    break;

            }

        }
        /* end of while(!exit) */
        System.exit(0);
        System.gc();
    }

}
