import java.util.*;
import java.security.*;
import javax.crypto.*;
import javax.xml.bind.*;

public class DESAlgo
{
    public static void main(String[] args)
    {
        String plaintext, ciphertext, decryptedtext, key;
        Scanner inputScanner = new Scanner(System.in);

        inputScanner.useDelimiter("[\\r\\n]+");

        System.out.println("DES");
        System.out.print("Enter the plaintext: ");
        plaintext = inputScanner.next();
        try
        {
            SecretKey skey = KeyGenerator.getInstance("DES").generateKey();    
            System.out.println("The auto-generated DES key is: " + DatatypeConverter.printHexBinary(skey.getEncoded()));
            DES des = new DES(skey);
            ciphertext = des.Encrypt(plaintext);
            System.out.println("The encrypted data is: " + ciphertext);
            decryptedtext = des.Decrypt(ciphertext);
            System.out.println("The decrypted data is: " + decryptedtext);
        }
        catch(Exception e)
        {
            System.out.println("Error trying to use DES");
        }
    }
}

class DES
{
    Cipher desEncryptCipher;
    Cipher desDecryptCipher;

    public DES(SecretKey key) throws Exception
    {
        desEncryptCipher = Cipher.getInstance("DES");
        desDecryptCipher = Cipher.getInstance("DES");
        desEncryptCipher.init(Cipher.ENCRYPT_MODE, key);
        desDecryptCipher.init(Cipher.DECRYPT_MODE, key);
    }

    public String Encrypt(String plaintext) throws Exception
    {
        byte[] utf8 = plaintext.getBytes("UTF-8");
        byte[] enc = desEncryptCipher.doFinal(utf8);

        return DatatypeConverter.printHexBinary(enc);
    }

    public String Decrypt(String ciphertext) throws Exception
    {
        byte[] dec = DatatypeConverter.parseHexBinary(ciphertext);
        byte[] utf8 = desDecryptCipher.doFinal(dec);

        return new String(utf8, "UTF-8");
    }
}