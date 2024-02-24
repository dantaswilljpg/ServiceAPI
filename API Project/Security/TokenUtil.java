import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class TokenUtil {

    private static final String CHAVE_SECRETA = "Segredo";

    public static String gerarToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 24 horas de validade
                .signWith(SignatureAlgorithm.HS512, CHAVE_SECRETA)
                .compact();
    }

    public static boolean validarToken(String token) {
        try {
            Jwts.parser().setSigningKey(CHAVE_SECRETA).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static String obterNomeUsuarioDoToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(CHAVE_SECRETA)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }
}
