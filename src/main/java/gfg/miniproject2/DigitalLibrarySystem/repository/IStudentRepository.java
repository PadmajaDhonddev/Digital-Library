package gfg.miniproject2.DigitalLibrarySystem.repository;

import gfg.miniproject2.DigitalLibrarySystem.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface IStudentRepository extends JpaRepository<Student, UUID> {
    @Override
    void deleteById(UUID id);
}
