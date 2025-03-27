package fr.posto.project.Posto.consumer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient;

public abstract class BasicConsumer
{
    protected final WebClient webClient;

    protected BasicConsumer(WebClient.Builder builder, String baseUrl, String apiKey)
    {
        this.webClient = builder
                .baseUrl(baseUrl)
                .defaultHeader("X-Api-Key", apiKey)
                .build();
    }
}

