import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicoRecomendacao {

    private final ServicoAPIExterna servicoAPIExterna;

    @Autowired
    public ServicoRecomendacao(ServicoAPIExterna servicoAPIExterna) {
        this.servicoAPIExterna = servicoAPIExterna;
    }

    public String gerarRecomendacaoTreino(String userId) {

        ResponseEntity<String> respostaDadosExercicio = servicoAPIExterna.buscarDadosExercicio(userId);
        String dadosExercicio = respostaDadosExercicio.getBody();
       
        return "Recomendação de treino para o usuário " + userId;
    }

    public String gerarRecomendacaoDieta(String userId) {
     
        return "Recomendação de dieta para o usuário " + userId;
    }

    public String atualizarRecomendacaoTreinoComFeedback(String userId, String feedback) {
        
        return "Recomendação de treino atualizada para o usuário " + userId + " com feedback: " + feedback;
    }
}
