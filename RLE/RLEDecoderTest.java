import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class RLEDecoderTest {
	
	@Test
	public void testIO() throws IOException {
	    String x = RLEDecoder.runLengthDecode("A3B14CD4C4BA3");
	    assertEquals("AAABBBBBBBBBBBBBBCDDDDCCCCBAAA", x);
	}

	//@Test
	public void testDecode1() throws IOException {
		String x = RLEDecoder.runLengthDecode("a3b3c3");
		assertEquals("aaabbbccc", x);
	}
	
	//@Test
	public void testDecode2() throws IOException {
		String x = RLEDecoder.runLengthDecode("@2");
		assertEquals("@@", x);
	}
	
	//@Test //(expected = IOException.class)
	public void testDecode3() throws IOException {
		String x = RLEDecoder.runLengthDecode("bbb");
		assertEquals("bbb", x);
	}
	
	//@Test //(expected = IOException.class)
	public void testDecode4() throws IOException {
		String x = RLEDecoder.runLengthDecode("B2C");
		assertEquals("BBC", x);
	}
	
}