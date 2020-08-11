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
public class FacadeATM {

    private static FacadeATM atm = new FacadeATM();
    private static handleCash dollar20;
    private handleCash dollar10;
    private handleCash dollar5;
    private handleCash dollar1;
    private Account account = new Account();

    private FacadeATM() {
        dollar20 = new Dollar20();
        dollar10 = new Dollar10();
        dollar5 = new Dollar5();
        dollar1 = new Dollar1();
        dollar20.setNext(dollar10);
        dollar10.setNext(dollar5);
        dollar5.setNext(dollar1);
    }

    public static FacadeATM getInstance() {
        return atm;
    }

    public void balance() {
        System.out.printf("%.2f", account.getBalance());
        /* user wants to check balance */
        System.out.println("");
    }

    public void deposit() {
        account.setDeposit_frequency(account.getDeposit_frequency()+1);
        if (account.candeposit(account.getDeposit_frequency())) {
            /* allow only if maximum frequency not met */
            System.out.print("Please enter the amount to deposit: ");
            int deposit_amount = new Scanner(System.in).nextInt();
            account.setNew_balance(account.deposit(deposit_amount));
            /* user wants to deposit money */
            System.out.printf("New Balance: %.2f", account.getNew_balance());
            System.out.println("");
        } else {
            /* maximum frequncy for the day met */
            System.out.println("ERROR: You have reached the maximum frequency of deposited per day.");
        }
        /* end of if(deposidt_frequence < 4) */
    }

    public void withdrawal() {
        account.setWithdrawal_frequency(account.getWithdrawal_frequency() +1 );
        if (account.canwithdraw(account.getWithdrawal_frequency())) {
            /* allow only if maximum frequency not met */
            System.out.print("Please enter the amount to withdraw: ");
            int withdrawal_amount = new Scanner(System.in).nextInt();
            account.setNew_balance(account.withdrawal(withdrawal_amount));
            dollar20.getCash(withdrawal_amount);
            /* user wants to withdraw money */
            System.out.printf("New Balance: %.2f", account.getNew_balance());
            System.out.println("");
        } else {
            /* maximum frequncy met for the day */
            System.out.println("ERROR: You have reach the maximum frequency of withdrawal per day.");
        }
        /* end of if(withdrawal_frequency < 3) */
    }

}
