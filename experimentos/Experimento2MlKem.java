package experimentos;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import javax.crypto.KEM;

public class Experimento2MlKem 
{
    public static void main(String[] args) throws Exception {
        
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("ML-KEM"); 
        KeyPair kp = kpg.generateKeyPair();
        PublicKey publicKey = kp.getPublic();
        
        KEM ks = KEM.getInstance("ML-KEM");
        
        KEM.Encapsulator enc = ks.newEncapsulator(publicKey);
        
        KEM.Encapsulated encap = enc.encapsulate();
        System.out.println("Chave encapsulada com sucesso!");
    }
}