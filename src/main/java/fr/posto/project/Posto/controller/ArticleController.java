package fr.posto.project.Posto.controller;

import com.kwabenaberko.newsapilib.models.Article;
import fr.posto.project.Posto.repository.ArticleRepository;
import fr.posto.project.Posto.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/news")
public class ArticleController
{
    private final ArticleService articleService;

    @Autowired
    private ArticleRepository articleRepository;

    public ArticleController(ArticleService articleService)
    {
        this.articleService = articleService;
    }

    @GetMapping("/search")
    public List<Article> searchNews(@RequestParam(value = "keyword", required = false) String keyword)
    {
        List<Article> articles = new ArrayList<>();


        return articles;
    }

    @GetMapping("/ping")
    public String ping()
    {
        List<fr.posto.project.Posto.model.Article> list;
        list = articleRepository.findAll();

        return "pong";
    }
}


