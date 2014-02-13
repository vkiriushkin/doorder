package sample.com.doorder.door.simple;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Encryptor {

	public static final Logger LOGGER = LoggerFactory.getLogger(Encryptor.class);

	public String encryptionKey;

	public static void main(String args[]) {
        Encryptor encryptor = new Encryptor();
        String encrypt = encryptor.encrypt("");
		System.out.println("decrypted value:" + encryptor.decrypt(encryptor.encryptionKey, encrypt));
	}

	public String encrypt(String value) {
		try {
            //read csv file with prices
            Scanner priceScanner = new Scanner(Encryptor.class.getResourceAsStream("price.csv"));
            StringBuilder builder = new StringBuilder();
            while(priceScanner.hasNext()) {
                String[] priceLine = priceScanner.nextLine().split(",");
                builder.append(priceLine[0] + ":" + priceLine[1] + ";");
            }

			// Get the KeyGenerator
			KeyGenerator kgen = KeyGenerator.getInstance("AES");
			kgen.init(128);
			// Generate the secret key specs.
			SecretKey skey = kgen.generateKey();
			byte[] raw = skey.getEncoded();
			String key = new Base64().encodeAsString(raw);
			this.encryptionKey = key;
			System.out.println("------------------Key------------------");
			System.out.println("------Key length: "+ key.length() +"------------------");
			System.out.println(key);
			System.out.println("--------------End of Key---------------");
			SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
//			String encrypt = (new Base64()).encodeAsString(cipher.doFinal(value.getBytes()));
			String encrypt = (new Base64()).encodeAsString(cipher.doFinal(builder.toString().getBytes()));
			System.out.println("encrypted string:" + encrypt);
			return encrypt;
		} catch (NoSuchAlgorithmException ex) {
//			Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalBlockSizeException ex) {
//			Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
		} catch (BadPaddingException ex) {
//			Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InvalidKeyException ex) {
//			Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
		} catch (NoSuchPaddingException ex) {
//			Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
		}
        return null;
	}

	public String decrypt(String key, String encrypted) {
		try {
			Key k = new SecretKeySpec(new Base64().decode(key), "AES");
			Cipher c = Cipher.getInstance("AES");
			c.init(Cipher.DECRYPT_MODE, k);
			byte[] decodedValue = new Base64().decode(encrypted);
			byte[] decValue = c.doFinal(decodedValue);
			String decryptedValue = new String(decValue);
			return decryptedValue;
		} catch (IllegalBlockSizeException ex) {
//			Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
		} catch (BadPaddingException ex) {
//			Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
		} catch (InvalidKeyException ex) {
//			Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
		} catch (NoSuchAlgorithmException ex) {
//			Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
		} catch (NoSuchPaddingException ex) {
//			Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}
}
