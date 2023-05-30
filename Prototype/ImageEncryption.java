import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.*;


public class ImageEncryption {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/ECB/PKCS5Padding";
    private static final String KEY = "YourKey__"; // Change this to your own secret key

    public static void encryptImage(String inputImagePath, String outputImagePath) throws Exception {
        Key secretKey = new SecretKeySpec(KEY.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        Path inputFile = Paths.get(inputImagePath);
        byte[] inputBytes = Files.readAllBytes(inputFile);
        byte[] encryptedBytes = cipher.doFinal(inputBytes);

        Path outputFile = Paths.get(outputImagePath);
        Files.write(outputFile, encryptedBytes);
    }

    public static void decryptImage(String inputImagePath, String outputImagePath) throws Exception {
        Key secretKey = new SecretKeySpec(KEY.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        Path inputFile = Paths.get(inputImagePath);
        byte[] inputBytes = Files.readAllBytes(inputFile);
        byte[] decryptedBytes = cipher.doFinal(inputBytes);

        Path outputFile = Paths.get(outputImagePath);
        Files.write(outputFile, decryptedBytes);
    }
}