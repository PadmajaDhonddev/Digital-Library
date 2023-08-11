package gfg.miniproject2.DigitalLibrarySystem.repository;

import gfg.miniproject2.DigitalLibrarySystem.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ITransactionRepository extends JpaRepository<Transaction, UUID> {
    @Override
    void deleteById(UUID uuid);
}
