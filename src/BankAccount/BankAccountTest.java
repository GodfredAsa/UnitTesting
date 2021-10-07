package BankAccount;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

// to fully understand the concepts and of this set suit refer to the bankAccount class
public class BankAccountTest {
    private BankAccount account; // variable of type bankAccount

// the setup() tells the compiler to run this code in every method when executing the program.
// Hence the commenting of the instance of the closs in all the testing methods.NOTE:
// THE SETUP METHOD RUNS EVERYTIME BEFORE A METHOD OR CODE IS RUN. IT IS DONE TO AVOID THE
// REPETITION OF CODE ALL OVER IN THE TEST CASES.

    @org.junit.BeforeClass
    public static void BeforeClass(){
        System.out.println("This method executes before any test cases.");
    }

    @org.junit.Before
    public void setup(){
//        bankAccount var being instantiated below
        account = new BankAccount("Tim", "Makarhane", 1000, BankAccount.CHECKING);
        System.out.println("Running tests ");
    }
// A METHOD THAT EXECUTES BEFORE ANY TEST CASE.


// SAMPLE OF A TEST CASE
    @org.junit.Test
    public void deposit() throws Exception{
      // THE setup() IS EXECUTED BEFORE ANY TEST CASE IS LIKE THIS CODE.
        double balance = account.deposit(200, true);
        assertEquals(1200, balance, 0);
        // assertEquals below is used to test if the balance is as expected.
        assertEquals(1200, account.getBalance(), 0);
    }

    @org.junit.Test
    public void withdraw_branch() throws Exception {
        double balance = account.withdraw(600.0, true);
        assertEquals(400.0, balance, 0);
    }

//   we need to remove the assertEquals because testing for Illegal Argument Exception
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void withdraw_notBranch() throws Exception{
         account.withdraw(600.0, false);
         fail("The code should have thrown an IllegalArgumentException");
         assertEquals(400.0, account.getBalance(),0);
    }
// the getBalance method was duplicated and customised to suit both deposit and withdraw to
// test each scenario.
    @org.junit.Test
    public void getBalance_deposit() throws Exception{
        // THE setup() IS EXECUTED BEFORE ANY TEST CASE IS LIKE THIS CODE.
        account.deposit(200.00, true);
        assertEquals(1200.00, account.getBalance(), 0);
    }

    @org.junit.Test
    public void getBalance_withdraw() throws Exception {
        // creating an instance of the bankAccount class to test withdraw method
//        BankAccount account1 = new BankAccount("Tim", "Makarhane", 1000.00, BankAccount.CHECKING);
        account.withdraw(200.00, true);
        assertEquals(800.00, account.getBalance(), 0);
    }

    @org.junit.Test
    public void isChecking_true() throws Exception{
        // THE setup() IS EXECUTED BEFORE ANY TEST CASE IS LIKE THIS CODE.
        assertTrue("The account is not a checking one ", account.isChecking());
        // the message section of the assertTrue only shows if the account is not as stated or fails
//        assertFalse(account1.isChecking()); used to check if a condition is false.
    }

    @org.junit.AfterClass
    public static void AfterClass(){
        System.out.println("This method executes after the test cases");
    }

    // thats my dummy test
    @org.junit.Test
    public void dummyTest() throws Exception{
        assertEquals(20,20);
    }

}