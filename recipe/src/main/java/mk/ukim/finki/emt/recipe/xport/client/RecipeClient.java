package mk.ukim.finki.emt.recipe.xport.client;

import mk.ukim.finki.emt.recipe.domain.models.Recipe;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;

@Service
public class RecipeClient {
    private final RestTemplate restTemplate;
    private final String serverUrl;

    public RecipeClient(@Value("${app.recipe.url}") String serverUrl) {
        this.serverUrl = serverUrl;
        this.restTemplate = new RestTemplate();
        var requestFactory = new SimpleClientHttpRequestFactory();
        this.restTemplate.setRequestFactory(requestFactory);
    }

    private UriComponentsBuilder uri() {
        return UriComponentsBuilder.fromUriString(this.serverUrl);
    }

    public List<Recipe> findAll() {
        try {
            return restTemplate.exchange(uri().path("/api/recipe").build().toUri(), HttpMethod.GET,null, new ParameterizedTypeReference<List<Recipe>>() {
            }).getBody();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

}