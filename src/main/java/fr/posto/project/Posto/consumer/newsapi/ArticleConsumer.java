package fr.posto.project.Posto.consumer.newsapi;

import fr.posto.project.Posto.dto.ArticleDTO;
import fr.posto.project.Posto.repository.ArticleRepository;
import org.springframework.stereotype.Component;
import java.util.List;
import fr.posto.project.Posto.consumer.BasicConsumer;
import fr.posto.project.Posto.wrapper.ArticleWrapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class ArticleConsumer extends BasicConsumer {

    public ArticleConsumer(WebClient.Builder builder, @Value("${newsapi.key}") String apiKey) {
        super(builder, "https://newsapi.org/v2", apiKey);
    }

    public List<ArticleDTO> getByKeyword(String keyword) {
        List<ArticleDTO> dtos;

        dtos = webClient.get().uri("/everything?q=" + keyword + "&language=fr&sortBy=popularity").retrieve().bodyToMono(ArticleWrapper.class).block().getArticles();

        return dtos;
    }
}

