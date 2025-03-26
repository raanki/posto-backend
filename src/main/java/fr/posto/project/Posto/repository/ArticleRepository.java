package fr.posto.project.Posto.repository;

import fr.posto.project.Posto.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    public List<Article> findByTitle(String name);
}
