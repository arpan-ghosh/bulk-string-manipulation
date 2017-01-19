import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class RLEEncoderTest {
	
	@Test
	public void testLetters() throws IOException {
		String x = RLEEncoder.runLengthEncode("AAABCDEFZXYEaaab");
		assertEquals("A3BCDEFZXYEa3b", x);
	}
	
	@Test
	public void testExample() throws IOException {
		String x = RLEEncoder.runLengthEncode("AAABBBBBBBBBBBBBBCDDDDCCCCBAAA");
		assertEquals("A3B14CD4C4BA3", x);
	}
	
	@Test
	public void testLetters2() throws IOException {
		String x = RLEEncoder.runLengthEncode("AAABBBCCC");
		assertEquals("A3B3C3", x);
	}
	
	@Test (expected = IOException.class)
	public void testNumbers() throws IOException {
		String x = RLEEncoder.runLengthEncode("111aaabbbccc");
	}
	
	@Test (expected = IOException.class)
	public void testLettersAndTwoDigitNumbers() throws IOException {
		String x = RLEEncoder.runLengthEncode("AAAbbb111AAAAAAAAAA");
	}
	
	@Test
	public void testSpecialChars() throws IOException {
		String x = RLEEncoder.runLengthEncode("@@@_#%%");
		assertEquals("@3_#%2", x);
	}
	
	@Test (expected = IOException.class)
	public void testIO() throws IOException {
		String invalid = RLEEncoder.runLengthEncode("11AA");
	}
	
	@Test (expected = IOException.class)
	public void testIOSpecialChars() throws IOException {
		String invalid = RLEEncoder.runLengthEncode("@@@222");
	}	
}