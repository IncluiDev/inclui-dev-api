package incluidevapi.component.util;

import incluidevapi.data.model.dynamic.RecuperacaoSenhaModel;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.HttpRetryException;

@Service
@RequiredArgsConstructor
public class WebClient {
    private final RestTemplate client;

    @Value("${api.email.url}") private String url;
    @Value("${api.email.role}") private String role;
    @Value("${api.email.password}") private String password;

    @Retryable(value = HttpRetryException.class, maxAttempts = 5, backoff = @Backoff(delay = 100))
    public void sendRecuperacaoEmail(RecuperacaoSenhaModel recuperacao) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBasicAuth(this.role, this.password);

        client.exchange(
                 this.url+"/recuperacao",
                HttpMethod.POST,
                new HttpEntity<>(recuperacao, headers),
                Object.class
        );
    }
}
