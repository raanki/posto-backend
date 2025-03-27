package fr.posto.project.Posto.service;

import fr.posto.project.Posto.consumer.newsapi.ArticleConsumer;
import fr.posto.project.Posto.dto.ArticleDTO;
import fr.posto.project.Posto.mapper.ArticleMapper;
import fr.posto.project.Posto.model.Article;
import fr.posto.project.Posto.wrapper.ArticleWrapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class ArticleService
{

    private ArticleConsumer articleConsumer;

    public ArticleService(ArticleConsumer articleConsumer)
    {
        this.articleConsumer = articleConsumer;
    }

    public List<Article> searchArticles(String keyword)
    {
        List<ArticleDTO> dtos = articleConsumer.getByKeyword(keyword);
        List<Article> entities = dtos.stream().map(ArticleMapper::dtoToEntity).toList();

        return entities;
    }
}


