package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTests {

    @Test
    public void depositShouldIncreseBalanceWhenPositiveAmount() {

        double amount = 200.0;
        double expectedValue = 196.0;

        Account acc = new Account(1L, 0.0);
        acc.deposit(amount);

        Assertions.assertEquals(expectedValue, acc.getBalance());
    }

    @Test
    public void depositShouldDoNothingWhenNegativeAmount() {

        double amount = -500.0;
        double expectedValue = 200;

        Account acc =  new Account(1L, expectedValue);
        acc.deposit(amount);

        Assertions.assertEquals(expectedValue, acc.getBalance());
    }

    @Test
    public void fullWithdrawShouldClearBalance() {

        double expectedValue =  0.0;
        double initialBalance = 800.0;

        Account acc = new Account(1L, initialBalance);
        acc.fullWithdraw();

        Assertions.assertTrue(expectedValue == acc.getBalance());
    }

    @Test
    public void withdrawShouldDecreaseBalanceWhenSufficientBalance() {

        Account acc = new Account(1L, 800.0);
        acc.withdraw(500);

        Assertions.assertEquals(300, acc.getBalance());
    }

    @Test
    public void withdrawShouldThrowExceptionWhenInsufficientBalance() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Account acc = new Account(1L, 800.0);
            acc.withdraw(900);
        });
    }
}