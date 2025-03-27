package fr.posto.project.Posto.mapper;

import fr.posto.project.Posto.dto.ArticleDTO;
import fr.posto.project.Posto.dto.SourceDTO;
import fr.posto.project.Posto.model.Article;
import fr.posto.project.Posto.model.Source;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ArticleMapper
{
    public static Article dtoToEntity(ArticleDTO dto)
    {
        Article entity;
        entity = new Article();

        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setAuthor(dto.getAuthor());
        entity.setUrl(dto.getUrl());
        entity.setUrlToImage(dto.getUrlToImage());

        LocalDateTime publishedAtDate = LocalDateTime.parse(dto.getPublishedAt(), DateTimeFormatter.ISO_DATE_TIME);
        entity.setPublishedAt(publishedAtDate);

        SourceDTO sourceDTO = dto.getSource();
        Source source = new Source(sourceDTO.getCanonicalName(), sourceDTO.getName());
        entity.setSource(source);

        return entity;
    }
}
