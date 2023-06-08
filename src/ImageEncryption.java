import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.*;

public class ImageEncryption {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/ECB/PKCS5Padding";
 
    public static void encryptImage(String inputImagePath, String outputImagePath, Key sckey) throws Exception {
        Key secretKey = new SecretKeySpec(KEY.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        Path inputFile = Paths.get(inputImagePath);
        byte[] inputBytes = Files.readAllBytes(inputFile);
        byte[] encryptedBytes = cipher.doFinal(inputBytes);

        Path outputFile = Paths.get(outputImagePath);
        Files.write(outputFile, encryptedBytes);
    }

    public static void decryptImage(String inputImagePath, String outputImagePath, Key sckey) throws Exception {
        Key secretKey = new SecretKeySpec(KEY.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        Path inputFile = Paths.get(inputImagePath);
        byte[] inputBytes = Files.readAllBytes(inputFile);
        byte[] decryptedBytes = cipher.doFinal(inputBytes);

        Path outputFile = Paths.get(outputImagePath);
        Files.write(outputFile, decryptedBytes);
    }
    // public static void decryptImage(String inputImagePath, String outputImagePath, Key sckey) throws Exception {
    //     Cipher cipher = Cipher.getInstance(TRANSFORMATION);
    //     cipher.init(Cipher.DECRYPT_MODE, sckey);
    
    //     Path inputFile = Paths.get(inputImagePath);
    //     byte[] inputBytes = Files.readAllBytes(inputFile);
    //     byte[] decryptedBytes = cipher.doFinal(inputBytes);
    
    //     Path outputFile = Paths.get(outputImagePath);
    //     Files.write(outputFile, decryptedBytes);
    // }  
    // public static void decryptImage(String inputImagePath, String outputImagePath, Key sckey) throws Exception {
    //     Cipher cipher = Cipher.getInstance(TRANSFORMATION);
    //     cipher.init(Cipher.DECRYPT_MODE, sckey);
    
    //     Path inputFile = Paths.get(inputImagePath);
    //     byte[] inputBytes = Files.readAllBytes(inputFile);
    //     byte[] decryptedBytes = cipher.doFinal(inputBytes);
    
    //     Path outputFile = Paths.get(outputImagePath);
    //     Files.write(outputFile, decryptedBytes);
    // } 







    private static final String KEY = "0ff49c0594f13dfec53a86f1ef6d480e";
}