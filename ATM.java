/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;

import java.util.Scanner;

/**
 *
 * @author bijondesai
 */
public class ATM {

    /**
     * @param args the command line arguments
     */
    
    /* default constructor */
    public void ATM(){
        
    }
    
    /* variable declaration */
    public static double balance = 150000;                                      /* initial balance to allow withdrawal */
    public static double new_balance = 0;                                       /* balance after withdrawal or deposit */
    public static int deposit_frequency = 0;                                    /* deposit frequency counter */
    public static double max_deposit = 0;                                       /* maximum amount deposited */
    public static int withdrawal_frequency = 0;                                 /* withdrawal frequency counter */
    public static double max_withdrawal = 0;                                    /* maximum amount withdrew */
    public static boolean exit= false;                                          /* exit program when true */
    
    public static double getbalance(){          
        return balance;                                                         /* return account balance */
    }
    
    public static boolean candeposit(int deposit_frequency){                    /* check depsit frequency limit */
        return deposit_frequency <= 4;
    }                                                                           /* end of can deposit */
    
    public static double deposit(int deposit_amount){                           /* add deposit to balance */
        
        if(deposit_amount > 0){                                                 /* run only when deposit amount is non-negative */
            
            if(deposit_amount <= 40000){                                        /* deposit amount must be less than 40000 */    
                max_deposit += deposit_amount;
                if(max_deposit <= 150000){                                      /* maximum deposit for the day must be less than 150000 */
                    System.out.printf("Current Balance: %.2f", balance);
                    System.out.println("");
                    balance += deposit_amount;
                    return balance;
                } else {
                    System.out.println("ERROR: You have reached the limit for maximum deposit per day.");
                }                                                               /* end of if(max_deposit <= 150000) */
            } else {
                System.out.println("ERROR: Maximum deposit amount must be less than 40000.00");
            }                                                                   /* end of if(deposit_amount <= 40000) */                                       
            
        } else {                                                                
            System.out.println("ERROR: Please enter a valid amount.");
        }                                                                       /* end of if(deposit_amount > 0) */
        
        return balance;
        
    }                                                                           /* end of deposit() */
    
    public static boolean canwithdraw(int withdrawal_frequency){                /* check withdrawal frequemcy limit */
        return withdrawal_frequency <= 3;
    }                                                                           /* end of canwithdraw() */
    
    public static double withdrawal(int withdrawal_amount){                     /* subtract withdrawal from balance */
        
        if(withdrawal_amount > 0){                                              /* run only if withdrawal amount is non-negative */
            
            if(withdrawal_amount < balance){                                    /* withdrawal amount must not be more than balance */
                
                if(withdrawal_amount <= 20000){                                 /* withdrawal amount must be less than 20000 */
                    max_withdrawal += withdrawal_amount;
                    if(max_withdrawal <= 50000){                                /* maximum withdrawal for the day must be 50000 */
                        System.out.printf("Current Balance: %.2f", balance);
                        System.out.println("");
                        balance -= withdrawal_amount;
                        return balance;
                    } else {
                        System.out.println("ERROR: You have reached the limit for maximum withdrawal per day.");
                    }                                                           /* end of if(max_withdrawal <= 50000) */
                } else {
                    System.out.println("ERROR: Maximum withdrawal amount must be less than 20000.00");
                }                                                               /* end of if(max_withdrawal <= 20000) */
            } else {
                
                System.out.printf("ERROR: Withdrawal amount is more than the balance: %.2f", balance);
                System.out.println("");
                
            }                                                                   /* end of if(withdrawal_amount < balance) */
        } else {
            System.out.println("ERROR: Please enter a valid amount.");
        }                                                                       /* end of if(withdrawal_amount > 0) */
        return balance;
    }                                                                           /* end of withdrawal() */
    
    public static boolean quit(String answer){                                  /* exit program */
        
        if(answer.equals("yes") || answer.equals("YES")){                       /* exit only after confirmation from user */
            return true;
        } else {
            return false;
        }                                                                       /* end of if loop */
        
    }                                                                           /* end of quit() */
    
    public static boolean userInput(String choice){
        
        switch(choice){
            case "BALANCE": System.out.printf("%.2f", getbalance());            /* user wants to check balance */
                    System.out.println("");
                    System.out.println("Type MENU to go back");
                    String menu = new Scanner(System.in).nextLine();
                    break;

            case "DEPOSIT": deposit_frequency++;
                    if(candeposit(deposit_frequency)){                          /* allow only if maximum frequency not met */
                        System.out.print("Please enter the amount to deposit: ");
                        int deposit_amount = new Scanner(System.in).nextInt();     
                        new_balance = deposit(deposit_amount);                  /* user wants to deposit money */
                        System.out.printf("New Balance: %.2f", new_balance);
                        System.out.println("");
                    } else {                                                    /* maximum frequncy for the day met */
                        System.out.println("ERROR: You have reached the maximum frequency of deposited per day.");
                    }                                                           /* end of if(deposidt_frequence < 4) */
                    break;

            case "WITHDRAWAL": withdrawal_frequency++;
                    if(canwithdraw(withdrawal_frequency)){                      /* allow only if maximum frequency not met */
                        System.out.print("Please enter the amount to withdraw: ");
                        int withdrawal_amount = new Scanner(System.in).nextInt();
                        new_balance = withdrawal(withdrawal_amount);            /* user wants to withdraw money */
                        System.out.printf("New Balance: %.2f", new_balance);
                        System.out.println("");
                    } else {                                                    /* maximum frequncy met for the day */
                        System.out.println("ERROR: You have reach the maximum frequency of withdrawal per day.");
                    }                                                           /* end of if(withdrawal_frequency < 3) */
                    break;

            case "EXIT": System.out.print("Are you sure you want to exit?(YES/NO): ");
                    String answer = new Scanner(System.in).nextLine();
                    if(quit(answer)){                                           /* user wants to quit */
                        /*System.exit(0);
                        System.gc();*/
                        return true;
                    }
                    break;

            default: System.out.println("ERROR: Please enter from available options");
                     break;
                         
            }                                                                   /* end of switch-case */
        return false;
    }                                                                           /* end of userInput() */
    
    public static void main(String[] args) {
        // TODO code application logic here
       
        System.out.println("Welcome to the ATM Program");
        
        while(!exit){                                                           /* exit condition for switch-case */
            
            System.out.println("Below are the options for you to choose from:\n" +
                                "1. Type BALANCE to check your Balance\n" + 
                                "2. Type DEPOSIT to deposit money\n" +
                                "3. Type WITHDRAWAL to withdraw money\n" +
                                "4. Type EXIT to exit the program");            /* Ask user for input */
            
            Scanner scan = new Scanner(System.in);
            String c = scan.nextLine();
            
            exit = userInput(c);                                                /* process user input */
        }                                                                       /* end of while(!exit) */
        System.exit(0);
        System.gc();
    }                                                                           /* end of main */
}                                                                               /* end of class */
