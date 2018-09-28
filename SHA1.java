import java.util.*;
import java.security.*;
import javax.crypto.*;
import javax.xml.bind.*;

public class SHA1
{
    public static void main(String[] args)
    {
        String plaintext, ciphertext, decryptedtext, key;
        Scanner inputScanner = new Scanner(System.in);

        inputScanner.useDelimiter("[\\r\\n]+");

        System.out.println("SHA-1");
        System.out.print("Enter the plaintext: ");
        plaintext = inputScanner.next();
        try
        {
            MessageDigest md = MessageDigest.getInstance("SHA1");
            md.update(plaintext.getBytes("UTF-8"));
            byte[] digest = md.digest();
            System.out.println("The SHA-1 hash is: " + DatatypeConverter.printHexBinary(digest));
        }
        catch(Exception e)
        {
            System.out.println("Error trying to use SHA-1");
        }
    }
}