package dev.arisavinh.account.repository.jpa;

import dev.arisavinh.account.model.entity.AccountEntity;
import org.sekailabs.jpaq.repositories.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountRepository extends BaseRepository<AccountEntity, UUID> {
}
