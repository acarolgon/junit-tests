import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CodeTest {
	
	@Test
	public void testSayHello() {
		Code code = new Code();
		assertEquals("Hello world!", code.sayHello());
	}

}
