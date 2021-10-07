package BankAccount;

public class BankAccount {
    private String firstName;
    private String lastName;
    private double balance;
    public static final int CHECKING =1;
    public static final int SAVINGS = 2;
    private int accountType;

    public BankAccount(String firstName, String lastName, double balance, int typeOfAccount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
        this.accountType = typeOfAccount;
    }
/** THE BRANCH ARGUMENT IS TRUE IF THE CUSTOMER IS PERFORMING THE TRANSACTION WITH A TELLER IN
 * THE BANK
 */
    public double deposit(double amount, boolean branch){
        balance +=amount;
        return balance;
    }

    /** THE BRANCH ARGUMENT IS TRUE IF THE CUSTOMER IS PERFORMING THE TRANSACTION WITH A TELLER IN
     * THE BANK
     */
    public double withdraw(double amount, boolean branch){
        if((amount>500.0) && !branch){
            throw new IllegalArgumentException();
        }
        balance -=amount;
        return balance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isChecking(){
        return accountType==CHECKING;
    }
}
