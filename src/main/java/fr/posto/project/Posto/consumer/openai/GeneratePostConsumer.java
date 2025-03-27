package fr.posto.project.Posto.consumer.openai;

import fr.posto.project.Posto.consumer.BasicConsumer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class GeneratePostConsumer extends BasicConsumer
{
    public GeneratePostConsumer(WebClient.Builder builder, @Value("${openai.key}") String apiKey)
    {
        super(builder, "https://api.openai.com/v1", apiKey);
    }

    public String generatePost(String prompt)
    {
        String body = """
            {
                "model": "gpt-4o",
                "messages": [
                    {
                        "role": "user",
                        "content": "%s"
                    }
                ]
            }
            """.formatted(prompt);

        return webClient.post()
                .uri("/chat/completions")
                .body(BodyInserters.fromValue(body))
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}

