import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;
import sun.misc.BASE64Encoder;
public class digitalsignature {
	public static void main(String[] args) throws Exception {
		KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
		kpg.initialize(1024);
		KeyPair keyPair = kpg.genKeyPair();
		byte[] data = "Sample Text".getBytes();
		Signature sig = Signature.getInstance("MD5WithRSA");
		
		//signing the data using the private key
		sig.initSign(keyPair.getPrivate());
		sig.update(data);
		byte[] signatureBytes = sig.sign();
		System.out.println("Signature: \n" + new BASE64Encoder().encode(signatureBytes));
		
		
		//verifying the data using public key
		sig.initVerify(keyPair.getPublic());
		sig.update(data);
		System.out.println("verification of signature at receiver: "+sig.verify(signatureBytes));	
		
	}
}