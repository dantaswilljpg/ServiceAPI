import java.time.LocalDateTime;
import java.util.List;

public class MensagemChat {
    private String idMensagem;
    private String conteudo;
    private String remetente;
    private LocalDateTime horario;
    private TipoMensagem tipo;
    private String idSala;
    private List<String> mencoes;
    private List<String> hashtags;
    private List<String> anexos;


    public MensagemChat() {
    }

    public MensagemChat(String idMensagem, String conteudo, String remetente, LocalDateTime horario, TipoMensagem tipo, String idSala, List<String> mencoes, List<String> hashtags, List<String> anexos) {
        this.idMensagem = idMensagem;
        this.conteudo = conteudo;
        this.remetente = remetente;
        this.horario = horario;
        this.tipo = tipo;
        this.idSala = idSala;
        this.mencoes = mencoes;
        this.hashtags = hashtags;
        this.anexos = anexos;
    }

    public String getIdMensagem() {
        return idMensagem;
    }

    public void setIdMensagem(String idMensagem) {
        this.idMensagem = idMensagem;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public LocalDateTime getHorario() {
        return horario;
    }

    public void setHorario(LocalDateTime horario) {
        this.horario = horario;
    }

    public TipoMensagem getTipo() {
        return tipo;
    }

    public void setTipo(TipoMensagem tipo) {
        this.tipo = tipo;
    }

    public String getIdSala() {
        return idSala;
    }

    public void setIdSala(String idSala) {
        this.idSala = idSala;
    }

    public List<String> getMencoes() {
        return mencoes;
    }

    public void setMencoes(List<String> mencoes) {
        this.mencoes = mencoes;
    }

    public List<String> getHashtags() {
        return hashtags;
    }

    public void setHashtags(List<String> hashtags) {
        this.hashtags = hashtags;
    }

    public List<String> getAnexos() {
        return anexos;
    }

    public void setAnexos(List<String> anexos) {
        this.anexos = anexos;
    }
}
