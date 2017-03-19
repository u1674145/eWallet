package uk.edu.syntaxerror.ewallet;

import android.annotation.TargetApi;
import android.os.Build;

import java.util.Random;

/**
 * Account Details.
 *
 * @author (Aaron Dulai)
 * @version (March2017)
 */

class Account
{
    // The name of the account.
    private String accountName;
    // The number of accounts.
    private String accountNum;
    // The balance of the account.
    private double balance;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    Account(String name, String accNum)
    {
        accountName = name;
        accountNum = accNum;
        balance = 0;
    }

    /**
     * Displays the account number.
     */
    String getAccountNum()
    {
        return accountNum;
    }
    /**
     * Displays the account number.
     */
     String getAccountName()
    {
        return accountName;
    }

    /**
     * Returns the balance to the user.
     * @return the balance.
     */
     double getBalance()
    {
        return balance;
    }

    /**
     * Changes the account Name.
     */
     void setAccountName(String newName)
    {
        accountName = newName;
    }

    /**
     * Changes the account Number.
     */
     void setAccountNum(String newNumber)
    {
        accountNum = newNumber;
    }

    /**
     * Changes the account balance.
     */
    public void setBalance(int newBalance)
    {
        balance = newBalance;
    }

    @Override
    public String toString() {
        return "Account owner :\n" +
                "  " + accountName + "\n" +
                "Account number :\n" +
                "  " + accountNum + "\n" +
                "\n\nCurrent balance:" +
                "  " + balance + "\n" +
                "Balance avaible:" +
                "  " + balance;
    }

}