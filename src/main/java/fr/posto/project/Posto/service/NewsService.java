package fr.posto.project.Posto.service;

import com.kwabenaberko.newsapilib.NewsApiClient;
import com.kwabenaberko.newsapilib.models.Article;
import com.kwabenaberko.newsapilib.models.request.EverythingRequest;
import com.kwabenaberko.newsapilib.models.request.TopHeadlinesRequest;
import com.kwabenaberko.newsapilib.models.response.ArticleResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
public class NewsService
{
    @Value("${newsapi.key}")
    private String apiKey;


    public List<Article> searchArticles(String keyword)
    {
        NewsApiClient client;
        client = new NewsApiClient(apiKey);

        ArticleResponse[] response = new ArticleResponse[1];

        client.getEverything(
                new EverythingRequest.Builder()
                        .q(keyword)
                        .language("fr")
                        .sortBy("popularity")
                        .build(),
                new NewsApiClient.ArticlesResponseCallback()
                {
                    @Override
                    public void onSuccess(ArticleResponse res)
                    {
                        response[0] = res;
                    }

                    @Override
                    public void onFailure(Throwable throwable)
                    {
                        System.out.println("Erreur API : " + throwable.getMessage());
                    }
                }
        );

        try
        {
            Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        if (response[0] != null)
        {
            return response[0].getArticles();
        }

        return List.of();
    }

}
