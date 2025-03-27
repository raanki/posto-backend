package fr.posto.project.Posto.wrapper;

import fr.posto.project.Posto.dto.ArticleDTO;
import lombok.Getter;

import java.util.List;

@Getter
public class ArticleWrapper
{
    private List<ArticleDTO> articles;

    public void setArticles(List<ArticleDTO> articles)
    {
        this.articles = articles;
    }
}