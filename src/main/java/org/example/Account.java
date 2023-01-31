package org.example;
import java.util.logging.Level;
import java.util.logging.*;

class AmntNotEnoughException extends Exception{
    public AmntNotEnoughException (String message) {
        super(message);
    }
}
class Account {
    Logger l=Logger.getLogger("kitty");
    private String accntholdername;
    private int id;
    private double balance;
    Account(String accntname, int newid, double newbalance) {
        accntholdername = accntname;
        id = newid;
        balance = newbalance;
    }

    public double getBalance() {
        return balance;
    }

    public double withdraw(int amount) {
        try {
            if (amount > balance) {
                throw new AmntNotEnoughException("u dont have enough money to withdraw");
            } else {
                balance = balance - amount;
                return balance;
            }
        } catch (AmntNotEnoughException e) {
            l.log(Level.INFO, () -> e.getMessage());
            System.exit(0);
        }
        return balance;
    }
    double deposit(int amount) {
        balance = balance + amount;
        return balance;
    }
    public static void main(String[] args) {
        Logger l=Logger.getLogger("kitty");

        Account account1 = new Account("bhaargavi", 1122, 20000);
        l.log(Level.INFO,() ->"Account Holder name:" + " " + account1.accntholdername);
        l.log(Level.INFO,() ->"Account ID:" + " " + account1.id);
        l.log(Level.INFO,() ->"Initial Balance:" + account1.getBalance());
        l.log(Level.INFO,() ->"Balance after Withdraw:" + " " + account1.withdraw(1000000));
        l.log(Level.INFO,() ->"Balance after deposit" + " " + account1.deposit(3000));
    }
}