package uk.edu.syntaxerror.ewallet;

import java.util.HashMap;

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

    @Override
    public String toString() {
        return "Account:\n" +
                "Account Name =" + accountName + '\n' +
                "Account Number =" + accountNum + '\n' +
                '\n';
    }

    // The number of accounts.
    private String accountNum;
    // The balance of the account.
    private double balance;

    Account(String name, String accNum)
    {
        accountName = name;
        accountNum = accNum;
        balance = 0;
    }

    public String getAccountInfo()
    {
        return "Account Number: " + accountNum + "\nName of holder: " + accountName + balance +"\nBalance ";
    }

    /**
     * Displays the account number.
     */
    public String getAccountNum()
    {
        return accountNum;
    }
    /**
     * Displays the account number.
     */
    public String getAccountName()
    {
        return accountName;
    }

    /**
     * Returns the balance to the user.
     * @return the balance.
     */
    public double getBalance()
    {
        return balance;
    }

    /**
     * Changes the account Name.
     */
    public void setAccountName(String newName)
    {
        accountName = newName;
    }

    /**
     * Changes the account Number.
     */
    public void setAccountNum(String newNumber)
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

    public void f(HashMap map) {
        map.put("accountName", accountName);
        map.put("accountNum", accountNum);
    }
}