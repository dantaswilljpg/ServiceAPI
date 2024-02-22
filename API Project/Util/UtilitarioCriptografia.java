import javax.crypto.*;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;
import java.util.Base64;

public class UtilitarioCriptografia {

    private static final String ALGORITMO_CRIPTOGRAFIA_AES = "AES/GCM/NoPadding";
    private static final int TAMANHO_CHAVE_AES = 256;
    private static final int TAMANHO_IV_GCM = 12;
    private static final int TAMANHO_TAG_GCM = 16;

    public static String criptografar(String textoClaro, SecretKey chaveSecreta) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITMO_CRIPTOGRAFIA_AES);
        cipher.init(Cipher.ENCRYPT_MODE, chaveSecreta);
        byte[] iv = cipher.getIV();
        byte[] textoCriptografado = cipher.doFinal(textoClaro.getBytes());
        byte[] textoCifrado = new byte[iv.length + textoCriptografado.length];
        System.arraycopy(iv, 0, textoCifrado, 0, iv.length);
        System.arraycopy(textoCriptografado, 0, textoCifrado, iv.length, textoCriptografado.length);
        return Base64.getEncoder().encodeToString(textoCifrado);
    }

    public static String descriptografar(String textoCriptografado, SecretKey chaveSecreta) throws Exception {
        byte[] textoCifrado = Base64.getDecoder().decode(textoCriptografado);
        byte[] iv = new byte[TAMANHO_IV_GCM];
        System.arraycopy(textoCifrado, 0, iv, 0, iv.length);
        byte[] dadosCriptografados = new byte[textoCifrado.length - TAMANHO_IV_GCM];
        System.arraycopy(textoCifrado, iv.length, dadosCriptografados, 0, dadosCriptografados.length);

        Cipher cipher = Cipher.getInstance(ALGORITMO_CRIPTOGRAFIA_AES);
        cipher.init(Cipher.DECRYPT_MODE, chaveSecreta, new GCMParameterSpec(TAMANHO_TAG_GCM * 8, iv));
        return new String(cipher.doFinal(dadosCriptografados));
    }

    public static SecretKey gerarChaveAES() throws NoSuchAlgorithmException {
        KeyGenerator geradorChave = KeyGenerator.getInstance("AES");
        geradorChave.init(TAMANHO_CHAVE_AES);
        return geradorChave.generateKey();
    }
}
