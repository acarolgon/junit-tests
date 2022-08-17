import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BankAccountBeforeAndAfterTest {

	static BankAccount bankAccount;

	@BeforeAll
	public void prepTest() {
		System.out.println("Start Test ...");
		bankAccount = new BankAccount(500, 0);
	}
	
	@Test
	public void testWithdraw() {
		bankAccount.withdraw(300);
		assertEquals(200,bankAccount.getBalance());
	}
	
	@Test
	public void testDeposit() {
		bankAccount.deposit(300);
		assertEquals(500,bankAccount.getBalance());
	}
	
	@AfterAll
	public void endTest() {
		System.out.println("... End Test.");
	}
	
	

}
