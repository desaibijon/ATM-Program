/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ATM;

/**
 *
 * @author kenny
 */
public class Account {
    
    private double balance = 150000;
    /* initial balance to allow withdrawal */
    private double new_balance = 0;
    /* balance after withdrawal or deposit */
    private int deposit_frequency = 0;
    /* deposit frequency counter */
    private double max_deposit = 0;
    /* maximum amount deposited */
    private int withdrawal_frequency = 0;
    /* withdrawal frequency counter */
    private double max_withdrawal = 0;

    public Account() {
    }
    
    public boolean candeposit(int deposit_frequency) {
        /* check depsit frequency limit */
        return deposit_frequency <= 4;
    }

    public double deposit(int deposit_amount) {
        /* add deposit to balance */

        if (deposit_amount > 0) {
            /* run only when deposit amount is non-negative */

            if (deposit_amount <= 40000) {
                /* deposit amount must be less than 40000 */
                max_deposit += deposit_amount;
                if (max_deposit <= 150000) {
                    /* maximum deposit for the day must be less than 150000 */
                    System.out.printf("Current Balance: %.2f", balance);
                    System.out.println("");
                    balance += deposit_amount;
                    return balance;
                } else {
                    System.out.println("ERROR: You have reached the limit for maximum deposit per day.");
                }
                /* end of if(max_deposit <= 150000) */
            } else {
                System.out.println("ERROR: Maximum deposit amount must be less than 40000.00");
            }
            /* end of if(deposit_amount <= 40000) */

        } else {
            System.out.println("ERROR: Please enter a valid amount.");
        }
        /* end of if(deposit_amount > 0) */

        return balance;
    }

    public boolean canwithdraw(int withdrawal_frequency) {
        /* check withdrawal frequemcy limit */
        return withdrawal_frequency <= 3;
    }

    /* end of canwithdraw() */

    public double withdrawal(int withdrawal_amount) {
        /* subtract withdrawal from balance */

        if (withdrawal_amount > 0) {
            /* run only if withdrawal amount is non-negative */

            if (withdrawal_amount < balance) {
                /* withdrawal amount must not be more than balance */

                if (withdrawal_amount <= 20000) {
                    /* withdrawal amount must be less than 20000 */
                    max_withdrawal += withdrawal_amount;
                    if (max_withdrawal <= 50000) {
                        /* maximum withdrawal for the day must be 50000 */
                        System.out.printf("Current Balance: %.2f", balance);
                        System.out.println("");
                        balance -= withdrawal_amount;
                        return balance;
                    } else {
                        System.out.println("ERROR: You have reached the limit for maximum withdrawal per day.");
                    }
                    /* end of if(max_withdrawal <= 50000) */
                } else {
                    System.out.println("ERROR: Maximum withdrawal amount must be less than 20000.00");
                }
                /* end of if(max_withdrawal <= 20000) */
            } else {

                System.out.printf("ERROR: Withdrawal amount is more than the balance: %.2f", balance);
                System.out.println("");

            }
            /* end of if(withdrawal_amount < balance) */
        } else {
            System.out.println("ERROR: Please enter a valid amount.");
        }
        /* end of if(withdrawal_amount > 0) */
        return balance;
    }

    public double getBalance() {
        return balance;
    }

    public double getNew_balance() {
        return new_balance;
    }

    public void setNew_balance(double new_balance) {
        this.new_balance = new_balance;
    }

    public int getDeposit_frequency() {
        return deposit_frequency;
    }

    public void setDeposit_frequency(int deposit_frequency) {
        this.deposit_frequency = deposit_frequency;
    }

    public double getMax_deposit() {
        return max_deposit;
    }

    public void setMax_deposit(double max_deposit) {
        this.max_deposit = max_deposit;
    }

    public int getWithdrawal_frequency() {
        return withdrawal_frequency;
    }

    public void setWithdrawal_frequency(int withdrawal_frequency) {
        this.withdrawal_frequency = withdrawal_frequency;
    }

    public double getMax_withdrawal() {
        return max_withdrawal;
    }

    public void setMax_withdrawal(double max_withdrawal) {
        this.max_withdrawal = max_withdrawal;
    }
    
    
    
}
