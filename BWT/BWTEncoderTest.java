import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class BWTEncoderTest {
    
	BWTEncoder x = new BWTEncoder();
	
	
	@Test
	public void testBWTEncode() throws IOException {
		String c = x.createBWT("acaacg");
		assertEquals("gc$aaac", c);
	}
	
	@Test
	public void testBWTEncode2() throws IOException {
		String c = x.createBWT("Hello");
		assertEquals("o$Hell", c);
	}
	
	@Test (expected = IOException.class)
	public void testIO() throws IOException {
		String invalid = x.createBWT("a!");
	}
	
	@Test (expected = IOException.class)
	public void testIO2() throws IOException {
		String invalid = x.createBWT("act$g");
	}

}
