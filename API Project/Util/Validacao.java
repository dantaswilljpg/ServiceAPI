import java.util.regex.Pattern;

public class Validacao {

    private static final Pattern PADRAO_EMAIL = Pattern.compile(
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
    );

    private static final Pattern PADRAO_SENHA = Pattern.compile(
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$"
    );

    public static boolean validarEmail(String email) {
        return PADRAO_EMAIL.matcher(email).matches();
    }

    public static boolean validarSenha(String senha) {
        return PADRAO_SENHA.matcher(senha).matches();
    }
}
