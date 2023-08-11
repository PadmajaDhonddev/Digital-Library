package gfg.miniproject2.DigitalLibrarySystem.repository;

import gfg.miniproject2.DigitalLibrarySystem.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface IBookRepository extends JpaRepository<Book, UUID> {
    @Override
    void deleteById(UUID id);
}
