import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.*;

public class ImgEnDec{
    public static void main(String[] args) {
        String inputImagePath = "____Image file path_______";
        String encryptedImagePath = "_______Encrypted image file path______";
        String decryptedImagePath = "_______Decrypted image file path______";

        try {
            ImageEncryption.encryptImage(inputImagePath, encryptedImagePath);
            System.out.println("Image encrypted successfully.");

            ImageEncryption.decryptImage(encryptedImagePath, decryptedImagePath);
            System.out.println("Image decrypted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
