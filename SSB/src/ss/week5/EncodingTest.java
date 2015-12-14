package ss.week5;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

/**
 * A simple class that experiments with the Hex encoding
 * of the Apache Commons Codec library.
 *
 */
public class EncodingTest {
    public static void main(String[] args) throws DecoderException {
    	String input = "Hello World"; //hex =	48656c6c6f20576f726c64
    	input = "Hello Big World"; //hex =		48656c6c6f2042696720576f726c64
    	char[] hex = Hex.encodeHex(input.getBytes());
        System.out.println(hex);
        // space is 20;
        //char[] hexChar = hex.toCharArray();
        
        String decoded = new String(Hex.decodeHex(hex));
        System.out.println(decoded);
        
        byte[] base = Base64.encodeBase64(input.getBytes());
        System.out.println(new String(base));
        
        String inputHex = "010203040506";
        String hexDecode = Hex.encodeHexString(inputHex.getBytes());
        byte[] baseEncode = Base64.encodeBase64(hexDecode.getBytes());
        
        System.out.printf("Input: %50s \nDecoded hex: %50s \nEncoded base64: %50s, length: %d\n", inputHex, hexDecode, new String(baseEncode), baseEncode.length);
     
        String baseInput = "U29mdHdhcmUgU3lzdGVtcw==";
        System.out.println(new String(Base64.decodeBase64(baseInput.getBytes())));
        
        String as = "";

        for (int i = 0; i < 10; i++) {
        	as = as.concat("a");
        	//System.out.println(as);
        	System.out.println(Base64.encodeBase64String(as.getBytes()));
        }
    }
}
