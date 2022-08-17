import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountRepetedTestTest {
	@RepeatedTest(5)
	@DisplayName("Deposit 500 successfully")
	public void testDeposit(BankAccount bankAccount) {
		bankAccount.deposit(500);
		assertEquals(500, bankAccount.getBalance());
	}
	
	@RepeatedTest(5)
	@DisplayName("Deposit 500 successfully")
	public void testDepositRepetitionInfo(BankAccount bankAccount, RepetitionInfo repetitionInfo) {
		bankAccount.deposit(500);
		assertEquals(500, bankAccount.getBalance());
		System.out.println("Nr: " + repetitionInfo.getCurrentRepetition());
	}

}