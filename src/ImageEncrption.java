import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageEncrption {
    static void encryptImage(File file, File ofile, int key, boolean doEncrypt) {
        try {
            // encryption & decryption logic
            FileInputStream fis = new FileInputStream(file);
            byte[] data = new byte[fis.available()];
            fis.read(data);

            int i = 0;
            for (byte b : data) {
                data[i] = (byte) (b ^ key);
                i++;
            }

            FileOutputStream fos = new FileOutputStream(file);
            fos.write(data);
            fos.close();
            fis.close();

            String message;
            if (doEncrypt)
                message = "file Encrypted successfully.";
            else
                message = "file Decrypted successfully.";
            JOptionPane.showMessageDialog(null, message);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static void decryptImage(File file, File ofile, int key, boolean doEncrypt) {
        try {
            // encryption & decryption logic
            FileInputStream fis = new FileInputStream(file);
            byte[] data = new byte[fis.available()];
            fis.read(data);

            int i = 0;
            for (byte b : data) {
                data[i] = (byte) (b ^ key);
                i++;
            }

            FileOutputStream fos = new FileOutputStream(file);
            fos.write(data);
            fos.close();
            fis.close();

            String message;
            if (doEncrypt)
                message = "file Decrypted successfully.";
            else
                message = "file Decrypted successfully.";
            JOptionPane.showMessageDialog(null, message);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
