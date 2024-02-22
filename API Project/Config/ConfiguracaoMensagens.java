import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.support.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.support.converter.MessageConverter;
import org.springframework.messaging.support.converter.StringMessageConverter;

@Configuration
public class ConfiguracaoMensagens {

    @Bean
    public MessageConverter conversorMensagem() {
        return new MappingJackson2MessageConverter();
    }

    @Bean
    public MessageConverter conversorMensagemString() {
        return new StringMessageConverter();
    }
}
