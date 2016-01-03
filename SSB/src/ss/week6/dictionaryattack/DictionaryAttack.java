package ss.week6.dictionaryattack;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.DatatypeConverter;


public class DictionaryAttack {
	private Map<String, String> passwordMap;
	private Map<String, String> hashDictionary;

	/**
	 * Reads a password file. Each line of the password file has the form:
	 * username: encodedpassword
	 * 
	 * After calling this method, the passwordMap class variable should be
	 * filled with the content of the file. The key for the map should be
	 * the username, and the password hash should be the content.
	 * @param filename
	 */
	public void readPasswords(String filename) throws IOException{
		BufferedReader in = null;
		String[] splitInput;
		String input = null;
		
		try {
			in = new BufferedReader(new FileReader(filename));
			input = in.readLine();
		} catch (FileNotFoundException e){
			System.out.println("file not found");
		}
		passwordMap = new HashMap();
		if (input != null) {
			splitInput = input.split(": ");
			passwordMap.put(splitInput[0], splitInput[1]);
		}
	}
	/**
	 * Given a password, return the MD5 hash of a password. The resulting
	 * hash (or sometimes called digest) should be hex-encoded in a String.
	 * @param password
	 * @return
	 * @throws NoSuchAlgorithmException 
	 */
	public String getPasswordHash(String password) {
		MessageDigest md = null;
		System.out.println(password + " ; " + password.getBytes());
		try {
			md = MessageDigest.getInstance("MD5");	
		} catch (NoSuchAlgorithmException e) {
			System.out.println("this algorithm doesn't exsist");
		}
		byte[] output = md.digest(password.getBytes());
		System.out.println(output + " and: " + DatatypeConverter.printHexBinary(output) + " with; " + md.getAlgorithm());
		return DatatypeConverter.printHexBinary(output).toLowerCase();
	}
	/**
	 * Checks the password for the user the password list. If the user
	 * does not exist, returns false.
	 * @param user
	 * @param password
	 * @return whether the password for that user was correct.
	 */
	public boolean checkPassword(String user, String password) {
        // To implement
		return false;
	}

	/**
	 * Reads a dictionary from file (one line per word) and use it to add
	 * entries to a dictionary that maps password hashes (hex-encoded) to
     * the original password.
	 * @param filename filename of the dictionary.
	 */
    	public void addToHashDictionary(String filename) {
        // To implement        
    }
	/**
	 * Do the dictionary attack.
	 */
	public void doDictionaryAttack() {
		// To implement
	}
	public static void main(String[] args) {
		DictionaryAttack da = new DictionaryAttack();
		// To implement
		da.doDictionaryAttack();
	}

}
