package dev.arisavinh.account.model.entity;

import dev.anataarisa.common.model.entity.BaseUUIDEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "privileges")
@Table(
        name = "privileges",
        uniqueConstraints = {
                @UniqueConstraint(name = "uc_privilege_domain_target_action", columnNames = {"domain", "target", "action"})
        },
        indexes = {
        @Index(name = "domain_index", columnList = "domain"),
        @Index(name = "target_index", columnList = "target"),
        @Index(name = "action_index", columnList = "action")
})
public class PrivilegeEntity extends BaseUUIDEntity {
    @Column(name = "name", nullable = false, unique = true)
    private String name;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "domain", nullable = false, length = 50)
    private String domain;
    @Column(name = "target", nullable = false)
    private String target;
    @Column(name = "action",  nullable = false, length = 50)
    private String action;
}
