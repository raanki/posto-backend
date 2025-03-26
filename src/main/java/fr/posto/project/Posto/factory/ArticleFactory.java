package fr.posto.project.Posto.factory;

import fr.posto.project.Posto.model.Article;
import fr.posto.project.Posto.model.Source;

import java.awt.*;
import java.time.LocalDateTime;

public class ArticleFactory {

    public Article createArticle(
            String title,
            String description,
            String url,
            String author,
            String urlToImage,
            LocalDateTime publishedAt,
            Source source,
            TextArea content
    ) {
        Article article = new Article();
        article.setTitle(title);
        article.setDescription(description);
        article.setUrl(url);
        article.setAuthor(author);
        article.setUrlToImage(urlToImage);
        article.setPublishedAt(publishedAt);
        article.setSource(source);
        article.setContent(content);

        return article;
    }

}
