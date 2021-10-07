package BankAccount;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BankAccountTestParameterised {
    private BankAccount account;

    @org.junit.Test
    public void setup(){
        account = new BankAccount("Tim", "Buchalka", 1000.0, BankAccount.CHECKING);
    }
}
