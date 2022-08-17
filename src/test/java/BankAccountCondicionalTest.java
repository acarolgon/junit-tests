import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

public class BankAccountCondicionalTest {
	
	@Test
	@EnabledOnOs({OS.MAC})
	public void testMac() {}
	
	@Test
	@EnabledOnOs({OS.WINDOWS})
	public void testWin() {}
	
	@Test
	@EnabledOnJre(JRE.JAVA_11)
	public void testJRE() {}
	
	@Test
	@DisabledOnJre(JRE.JAVA_11)
	public void testNoJRE11() {}

}
