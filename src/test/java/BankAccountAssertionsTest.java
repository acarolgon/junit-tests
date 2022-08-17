import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BankAccountAssertionsTest {
	
	@Test
	@DisplayName("Withdraw will become negative")
	public void testWithdrawNotStuckAtZero() {
		BankAccount bankAccount = new BankAccount(500, -1000);
		bankAccount.withdraw(800);
		assertNotEquals(0, bankAccount.getBalance());

	}

	@Test
	@DisplayName("Test activate account after creation")
	public void testActive() {
		BankAccount bankAccount = new BankAccount(500, 0);
		assertTrue(bankAccount.isActive());
	}

	@Test
	@DisplayName("Test set holder name")
	public void testHolderNameSet() {
		BankAccount bankAccount = new BankAccount(500, 0);
		bankAccount.setHolderName("Ana Carolina");
		assertNotNull(bankAccount.getHolderName());
	}
	
	@Test
	@DisplayName("Test that we can't withdraw below minimim")
	public void testNoWithdrawBelowMinimum() {
		BankAccount bankAccount = new BankAccount(500, -1000);
		assertThrows(RuntimeException.class, () -> bankAccount.withdraw(2000));
	}
	
	@Test
	@DisplayName("Test no exceptions for withdraw and deposit")
	public void testWithdrawAndDepositWithoutExceptions() {
		BankAccount bankAccount = new BankAccount(500, -1000);
		assertAll(() -> bankAccount.deposit(200), () -> bankAccount.withdraw(450));
	}
	
	@Test
	@DisplayName("Test speed deposit")
	public void testDepositTimeout() {
		BankAccount bankAccount = new BankAccount(400, -500);
		assertTimeout(Duration.ofNanos(1), () -> bankAccount.deposit(200));
	}
}
