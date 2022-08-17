import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.DayOfWeek;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

@ExtendWith(BankAccountParameterResolver.class)
public class BankAccountParameterizedTestTest {
	
	@ParameterizedTest
	@ValueSource(ints = {100, 400, 800, 1000})
	@DisplayName("Depositing successfully")
	public void testDepositValueSource(int amount, BankAccount bankAccount) {
		bankAccount.deposit(amount);
		assertEquals(amount, bankAccount.getBalance());
	}
	
	@ParameterizedTest
	@EnumSource(value = DayOfWeek.class, names = {"TUESDAY", "THURSDAY"})
	public void testDayOfWeek(DayOfWeek day) {
		assertTrue(day.toString().startsWith("T"));
	}
	
	@ParameterizedTest
	//@CsvSource({"100, Eva","200, Otto", "150, Matilda"})
	@CsvFileSource(resources = "details.csv", delimiter=';')
	public void depositAndNameTest(double amount, String name, BankAccount bankAccount) {
		bankAccount.deposit(amount);
		bankAccount.setHolderName(name);
		assertEquals(amount, bankAccount.getBalance());
		assertEquals(name, bankAccount.getHolderName());
	}

}
