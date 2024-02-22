import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class ControladorChat {

    @MessageMapping("/chat/enviar")
    @SendTo("/topico/chat")
    public MensagemChat enviarMensagem(MensagemChat mensagem) {
        mensagem.setIdMensagem(UUID.randomUUID().toString());
        mensagem.setTimestamp(LocalDateTime.now());
        mensagem.setTipo(TipoMensagem.TEXTO);

        List<String> mencoes = extrairMencoes(mensagem.getConteudo());
        mensagem.setMencoes(mencoes);

        List<String> hashtags = extrairHashtags(mensagem.getConteudo());
        mensagem.setHashtags(hashtags);

        List<String> anexos = extrairAnexos(mensagem.getConteudo());
        mensagem.setAnexos(anexos);

        return mensagem;
    }

    @MessageMapping("/chat/historico/{salaId}")
    @SendTo("/topico/chat/{salaId}")
    public List<MensagemChat> obterHistoricoChat(@PathVariable String salaId) {
       
        return new ArrayList<>();
    }

    @MessageMapping("/chat/criarSala")
    @SendTo("/topico/salaCriada")
    public String criarSalaChat() {
      
        return "";
    }

    @MessageMapping("/chat/privado/{idUsuario}")
    @SendTo("/topico/privado/{idUsuario}")
    public MensagemChat enviarMensagemPrivada(@PathVariable String idUsuario, MensagemChat mensagem) {
       
        return mensagem;
    }

    @MessageMapping("/chat/entrarSala/{salaId}")
    @SendTo("/topico/entrarSala/{salaId}")
    public String entrarSalaChat(@PathVariable String salaId) {
        /
        return "";
    }

    private List<String> extrairMencoes(String conteudo) {
         return new ArrayList<>();
    }

    private List<String> extrairHashtags(String conteudo) {
        
        return new ArrayList<>();
    }

    private List<String> extrairAnexos(String conteudo) {
       
        return new ArrayList<>();
    }
}
