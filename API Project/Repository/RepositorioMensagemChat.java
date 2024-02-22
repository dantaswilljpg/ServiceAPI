import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioMensagemChat extends JpaRepository<MensagemChat, Long> {

    Page<MensagemChat> findByConteudoContaining(String conteudo, Pageable pageable);

    Page<MensagemChat> findByTimestampBetween(LocalDateTime dataInicio, LocalDateTime dataFim, Pageable pageable);

    Page<MensagemChat> findByIdUsuario(Long idUsuario, Pageable pageable);

    Page<MensagemChat> findByIdUsuarioIn(List<Long> idsUsuarios, Pageable pageable);
}
