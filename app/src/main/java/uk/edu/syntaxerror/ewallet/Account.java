package uk.edu.syntaxerror.ewallet;

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
        return "Account{" +
                "accountName='" + accountName + '\'' +
                ", accountNum='" + accountNum + '\'' +
                '}';
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
}