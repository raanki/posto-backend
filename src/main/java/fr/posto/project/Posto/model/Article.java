package fr.posto.project.Posto.model;

import jakarta.persistence.*;
import lombok.Data;

import java.awt.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Article extends CoreEntity {
    private Long externId;

    @Column(length = 1000)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(length = 1000)
    private String url;

    @Column(length = 1000)
    private String author;

    @Column(length = 1000)
    private String urlToImage;

    private LocalDateTime publishedAt;

    @Column(columnDefinition = "TEXT")
    private String content;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "source_id")
    private Source source;

}

