package gfg.miniproject2.DigitalLibrarySystem.repository;

import gfg.miniproject2.DigitalLibrarySystem.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ICardRepository extends JpaRepository<Card, UUID> {
    void deleteById(UUID id);
}
