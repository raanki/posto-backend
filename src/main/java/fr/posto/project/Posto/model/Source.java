package fr.posto.project.Posto.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Source extends CoreEntity {

    @Column(length = 1000)
    private String canonicalName;

    @Column(length = 1000)
    private String name;

    public Source(String canonicalName, String name) {
        super();
    }

    public Source() {

    }
}
