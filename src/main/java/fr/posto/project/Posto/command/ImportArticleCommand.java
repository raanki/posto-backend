package fr.posto.project.Posto.command;

import com.kwabenaberko.newsapilib.models.Article;
import fr.posto.project.Posto.factory.ArticleFactory;
import fr.posto.project.Posto.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ImportArticleCommand implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(ImportArticleCommand.class);
    private final ArticleService articleService;
    private final ArticleFactory articleFactory;

    public ImportArticleCommand(ArticleService articleService, ArticleFactory articleFactory) {
        this.articleService = articleService;
        this.articleFactory = articleFactory;
    }

    @Override
    public void run(String... args) throws Exception {

        if (args.length > 0 && !args[0].equals("import")) {
            return;
        }

        List<fr.posto.project.Posto.model.Article> articles;
        String keyword;

        keyword = "ia";
        articles = articleService.searchArticles(keyword);
        articleFactory.saveAll(articles);
        articleFactory.flush();



    }
}

