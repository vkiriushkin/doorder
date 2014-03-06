package price;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

public class Decryptor {

    public static void decrypt(String key, String encrypted) {
        try {
            Key k = new SecretKeySpec(new Base64().decode(key), "AES");
            Cipher c = Cipher.getInstance("AES");
            c.init(Cipher.DECRYPT_MODE, k);
            byte[] decodedValue = new Base64().decode(encrypted);
            byte[] decValue = c.doFinal(decodedValue);
            String decryptedValue = new String(decValue);

            //TODO: populate Price enum with proper values


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
    }
}
