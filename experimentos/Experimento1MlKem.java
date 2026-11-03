package experimentos;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.PrivateKey;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.spec.NamedParameterSpec;
import java.util.Base64;
import javax.crypto.KEM;
import javax.crypto.SecretKey;

import java.util.Arrays;


public class Experimento1MlKem {

    public static void main(String[] args) {

        try {
            // Destinatário gera seu par de chaves
            KeyPairGenerator algoritmo = KeyPairGenerator.getInstance("ML-KEM-768");
            KeyPair keyPairDestinatario = algoritmo.generateKeyPair();
            PublicKey publicKeyDestinatario = keyPairDestinatario.getPublic();

            KEM keyStructure = KEM.getInstance("ML-KEM-768");
            KEM.Encapsulator encapsuladorRemetente = keyStructure.newEncapsulator(publicKeyDestinatario);
            KEM.Encapsulated dockerEncapsulado = encapsuladorRemetente.encapsulate();

            System.out.println("Chave encapsulada com sucesso!");

            // Pacote cifrado e a chave secreta simétrica gerada para o remetente
            byte[] mensagem = dockerEncapsulado.encapsulation(); // Pacote cifrado para envio
            SecretKey secretKeyRemetente = dockerEncapsulado.key(); // Chave simétrica gerada no remetente

            System.out.println("Enviando mensagem para o destinatário...");

            PrivateKey privateKeyDestinatario = keyPairDestinatario.getPrivate(); // Usa a chave privada correta
            
            KEM kr = KEM.getInstance("ML-KEM-768");
            KEM.Decapsulator dec = kr.newDecapsulator(privateKeyDestinatario);
            SecretKey secretKeyDestinatario = dec.decapsulate(mensagem); // Recupera a mesma chave simétrica

            //Validação: Checa se as duas chaves simétricas são exatamente iguais
            boolean chavesIguais = Arrays.equals(secretKeyRemetente.getEncoded(), secretKeyDestinatario.getEncoded());
            System.out.println("As chaves secretas do Remetente e Destinatário são iguais? " + chavesIguais);


            System.out.println("Chave pública: " + publicKeyDestinatario.getEncoded().length + " bytes");
            System.out.println("Chave privada: " + privateKeyDestinatario.getEncoded().length + " bytes");
            System.out.println("Mensagem: " + mensagem.length + " bytes");
            System.out.println("Chave simétrica 1: " + secretKeyDestinatario.getEncoded().length + " bytes");
            System.out.println("Chave simétrica 2: " + secretKeyRemetente.getEncoded().length + " bytes");

        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
    }
}