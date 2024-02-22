import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.MetricsEndpoint;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class ServicoAPIBackend {

    private static final String URL_API_GOOGLE_PLACES = "https://maps.googleapis.com/maps/api/place/nearbysearch/json";
    
    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    private MetricsEndpoint metricsEndpoint;
    
    public ResponseEntity<String> buscarLocaisProximos(double latitude, double longitude, String palavraChave, String chaveAPI) {
        UriComponentsBuilder construtor = UriComponentsBuilder.fromHttpUrl(URL_API_GOOGLE_PLACES)
                .queryParam("location", String.format("%f,%f", latitude, longitude))
                .queryParam("radius", 5000)
                .queryParam("keyword", palavraChave)
                .queryParam("key", chaveAPI);

        return restTemplate.getForEntity(construtor.toUriString(), String.class);
    }
    
    public Object obterMetricas() {
        return metricsEndpoint.listNames();
    }
}
