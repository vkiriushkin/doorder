package price;

import org.apache.commons.codec.binary.Base64;
import sample.Controller;
import sample.com.doorder.door.Price;

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

            System.out.println(decryptedValue);
            String[] pricesArray = decryptedValue.split(";");
            for (int i = 0; i < pricesArray.length; i++) {
                String shortName = pricesArray[i].split(":")[0];
                String value = pricesArray[i].split(":")[1];
//                Price.lookupPriceByShortName(shortName).setPriceInUAH(Double.parseDouble(value));
            }

            for (Price price : Price.values()) {
                System.out.println(price.toString());
            }

        } catch (IllegalBlockSizeException ex) {
            Controller.showBrokenPriceLabel();
        } catch (BadPaddingException ex) {
            Controller.showBrokenPriceLabel();
        } catch (InvalidKeyException ex) {
            Controller.showBrokenPriceLabel();
        } catch (NoSuchAlgorithmException ex) {
            Controller.showBrokenPriceLabel();
        } catch (NoSuchPaddingException ex) {
            Controller.showBrokenPriceLabel();
        }
    }
}
