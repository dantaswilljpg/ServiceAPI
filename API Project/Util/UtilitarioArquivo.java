import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UtilitarioArquivo {

    public static String lerArquivo(String caminhoArquivo) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoArquivo)));
    }

    public static void escreverArquivo(String caminhoArquivo, String conteudo) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            bw.write(conteudo);
        }
    }

    public static String calcularHash(String caminhoArquivo) throws NoSuchAlgorithmException, IOException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] bytesHash = digest.digest(Files.readAllBytes(Paths.get(caminhoArquivo)));

        StringBuilder hexString = new StringBuilder();
        for (byte byteHash : bytesHash) {
            String hex = Integer.toHexString(0xff & byteHash);
            if (hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
