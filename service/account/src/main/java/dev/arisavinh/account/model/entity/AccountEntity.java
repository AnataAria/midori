package dev.arisavinh.account.model.entity;

import dev.anataarisa.common.model.entity.BaseUUIDEntity;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "accounts")
public class AccountEntity extends BaseUUIDEntity {
}
