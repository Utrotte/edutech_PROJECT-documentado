package cl.proyecto.edutech.repository;
//Victor Espindola
import cl.proyecto.edutech.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> { 
    List<Curso> findByInstructorInstructorId(Long instructorId); 
    List<Curso> findByTituloContainingIgnoreCase(String titulo); 
}