package gfg.miniproject2.DigitalLibrarySystem.repository;

import gfg.miniproject2.DigitalLibrarySystem.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IAuthorRepository extends JpaRepository <Author, UUID>{
}
