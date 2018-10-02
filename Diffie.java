import java.util.*;

public class Diffie
{
    public static void main(String[] args)
    {
        String plaintext, ciphertext, decryptedtext, key;
        Scanner inputScanner = new Scanner(System.in);

        inputScanner.useDelimiter("[\\r\\n]+");

        
        System.out.println("Diffie-Hellman Key Exchange");
        System.out.print("Enter a prime number (eg. 23): ");
        int p = inputScanner.nextInt();
        System.out.print("Enter a primitive root modulo " + p + " (eg. 5): ");
        int g = inputScanner.nextInt();
        System.out.print("Enter user A's secret number [a < p] (eg. 4): ");
        int a = inputScanner.nextInt();
        System.out.print("Enter user B's secret number [b < p] (eg. 3): ");
        int b = inputScanner.nextInt();
        int A = 1, B = 1;
        for(int i = 0; i < a; i++)
            A = (A * g) % p;//(g^a)%p
        for(int i = 0; i < b; i++)
            B = (B * g) % p;//(g^b)%p
        System.out.println("User A sends public A = " + A + " to user B");
        System.out.println("User B sends public B = " + B + " to user A");
        int Ka = 1, Kb = 1;
        for(int i = 0; i < a; i++)
            Ka = (Ka * B) % p;//(B^a)%p
        for(int i = 0; i < b; i++)
            Kb = (Kb * A) % p;//(A^b)%p
        System.out.println("User A calculates shared secret K = " + Ka);
        System.out.println("User B calculates shared secret K = " + Kb);
    }
}