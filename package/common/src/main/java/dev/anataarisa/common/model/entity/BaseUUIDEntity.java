package dev.anataarisa.common.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public class BaseUUIDEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;
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
