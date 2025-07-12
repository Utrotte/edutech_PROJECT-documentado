package cl.proyecto.edutech.repository; //ROBERTO GONZALEZ

import cl.proyecto.edutech.model.Instructor;
import cl.proyecto.edutech.model.Usuario; // Para buscar por usuario
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {
    Optional<Instructor> findByUsuario(Usuario usuario);
    Optional<Instructor> findByUsuarioUsuarioId(Long usuarioId);
}