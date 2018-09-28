import java.util.*;
import java.security.*;
import javax.crypto.*;
import javax.xml.bind.*;

public class RSAAlgo
{
    public static void main(String[] args)
    {
        String plaintext, ciphertext, decryptedtext, key;
        Scanner inputScanner = new Scanner(System.in);

        inputScanner.useDelimiter("[\\r\\n]+");

        System.out.println("RSA");
            
        System.out.print("Enter the plaintext: ");
        plaintext = inputScanner.next();
        try
        {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
            kpg.initialize(1024);
            KeyPair kp = kpg.generateKeyPair();
            PublicKey publicKey = kp.getPublic();
            PrivateKey privateKey = kp.getPrivate();
            System.out.println("The auto-generated RSA public key is: " + DatatypeConverter.printHexBinary(publicKey.getEncoded()));
            System.out.println();
            System.out.println("The auto-generated RSA private key is: " + DatatypeConverter.printHexBinary(privateKey.getEncoded()));
            System.out.println();
            RSA rsa = new RSA(publicKey, privateKey);
            ciphertext = rsa.Encrypt(plaintext);
            System.out.println("The encrypted data is: " + ciphertext);
            System.out.println();
            decryptedtext = rsa.Decrypt(ciphertext);
            System.out.println("The decrypted data is: " + decryptedtext);
        }
        catch(Exception e)
        {
            System.out.println("Error trying to use RSA");
        }
    }
}
class RSA
{
    Cipher rsaEncryptCipher;
    Cipher rsaDecryptCipher;

    public RSA(PublicKey publicKey, PrivateKey privateKey) throws Exception
    {
        rsaEncryptCipher = Cipher.getInstance("RSA");
        rsaDecryptCipher = Cipher.getInstance("RSA");
        rsaEncryptCipher.init(Cipher.ENCRYPT_MODE, publicKey);
        rsaDecryptCipher.init(Cipher.DECRYPT_MODE, privateKey);
    }

    public String Encrypt(String plaintext) throws Exception
    {
        byte[] utf8 = plaintext.getBytes("UTF-8");
        byte[] enc = rsaEncryptCipher.doFinal(utf8);

        return DatatypeConverter.printHexBinary(enc);
    }

    public String Decrypt(String ciphertext) throws Exception
    {
        byte[] dec = DatatypeConverter.parseHexBinary(ciphertext);
        byte[] utf8 = rsaDecryptCipher.doFinal(dec);

        return new String(utf8, "UTF-8");
    }
}