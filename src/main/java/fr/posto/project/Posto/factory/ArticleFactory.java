package fr.posto.project.Posto.factory;

import fr.posto.project.Posto.model.Article;
import fr.posto.project.Posto.model.Source;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.time.LocalDateTime;

@Component
public interface ArticleFactory extends JpaRepository<Article, Long> {

    public default Article createArticle(
            Long id,
            String title,
            String description,
            String url,
            String author,
            String urlToImage,
            LocalDateTime publishedAt,
            Source source,
            String content
    ) {

        Article article = new Article();
        article.setTitle(title);
        article.setExternId(id);
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
