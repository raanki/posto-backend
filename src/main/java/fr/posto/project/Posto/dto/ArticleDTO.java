package fr.posto.project.Posto.dto;

import lombok.Data;

@Data
public class ArticleDTO {
    private Long id;
    private String title;
    private String description;
    private String url;
    private String author;
    private String urlToImage;
    private String publishedAt;
    private String content;
    private SourceDTO source;

}
