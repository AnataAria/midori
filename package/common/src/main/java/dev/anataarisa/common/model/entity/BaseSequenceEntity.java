package dev.anataarisa.common.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.OffsetDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseSequenceEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    @Column(name = "created_date", nullable = false, updatable = false)
    private OffsetDateTime createdDate;
    @Column(name = "last_modified_date", nullable = false)
    private OffsetDateTime lastModifiedDate;

    @PrePersist
    protected void onCreate() {
        createdDate = OffsetDateTime.now();
        lastModifiedDate = OffsetDateTime.now();
    }
    @PreUpdate
    protected void onUpdate() {
        lastModifiedDate = OffsetDateTime.now();
    }
}
