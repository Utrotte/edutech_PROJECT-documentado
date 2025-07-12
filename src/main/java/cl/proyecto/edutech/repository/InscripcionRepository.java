package cl.proyecto.edutech.repository;//francisco Rodriguez

import cl.proyecto.edutech.model.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {
    List<Inscripcion> findByUsuarioUsuarioId(Long usuarioId);
    List<Inscripcion> findByCurso_cursoId(int cursoId);
    Optional<Inscripcion> findByUsuarioUsuarioIdAndCurso_cursoId(Long usuarioId, int cursoId);
}