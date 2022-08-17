import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountDisabledTest {
	
	@Test
	@Disabled("Temporarily disabled due to maintenance")
	@DisplayName("Deposit 500 successfully")
	public void testWithdraw(BankAccount bankAccount) {
		bankAccount.deposit(500);
		assertEquals(500, bankAccount.getBalance());
	}
}
