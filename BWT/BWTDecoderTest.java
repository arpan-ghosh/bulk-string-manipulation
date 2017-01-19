import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class BWTDecoderTest {

	@Test
	public void testBWTDecode() throws IOException {
		String c = BWTDecoder.decodeBWT("gc$aaac");
		assertEquals("acaacg", c);
	}
	
	@Test
	public void testBWTDecode2() throws IOException {
		String c = BWTDecoder.decodeBWT("Hello$");
		assertEquals("olleH", c);
	}
	
	@Test (expected = IOException.class)
	public void testIO() throws IOException {
		String invalid = BWTDecoder.decodeBWT("a!");
	}
	
	@Test (expected = IOException.class)
	public void testIO2() throws IOException {
		String invalid = BWTDecoder.decodeBWT("gc$ a");
	}

}
