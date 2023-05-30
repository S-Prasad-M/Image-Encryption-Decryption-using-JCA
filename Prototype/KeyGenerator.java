import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class KeyGenerator {
    public static void main(String[] args) {
        try {
            // Generate a random 128-bit AES key
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128);
            SecretKey secretKey = keyGenerator.generateKey();

            // Convert the secret key to bytes
            byte[] keyBytes = secretKey.getEncoded();

            // Convert the key bytes to a hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : keyBytes) {
                hexString.append(String.format("%02x", b));
            }

            System.out.println("Generated AES key: " + hexString.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
