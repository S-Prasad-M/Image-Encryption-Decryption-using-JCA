import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;

public class KeyConv {
    public static void main(String[] args) {
        String text = "12345"; // Replace with your desired text

        try {
            SecretKey aesKey = generateAESKey(text);
            byte[] keyBytes = aesKey.getEncoded();

            System.out.println("Text: " + text);
            System.out.print("AES Key (Hexadecimal): ");
            for (byte b : keyBytes) {
                System.out.printf("%02x", b);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    public static SecretKey generateAESKey(String text) throws NoSuchAlgorithmException {
        byte[] textBytes = text.getBytes(StandardCharsets.UTF_8);

        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        SecretKey aesKey = keyGenerator.generateKey();

        // Use the text bytes to derive the key
        for (int i = 0; i < textBytes.length; i++) {
            byte[] encodedKeyBytes = aesKey.getEncoded();
            encodedKeyBytes[i % encodedKeyBytes.length] ^= textBytes[i];
        }

        return aesKey;
    }
}
