import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.logging.LoggingSystem;

@Configuration
public class ConfiguracaoLogging {

    @Bean
    public LoggingSystem sistemaDeLogging() {
        return LoggingSystem.get(getClass().getClassLoader());
    }
}
