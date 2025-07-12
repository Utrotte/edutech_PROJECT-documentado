package cl.proyecto.edutech.repository;//FRANCISCO RODRIGUEZ

import cl.proyecto.edutech.model.Pregunta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PreguntaRepository extends JpaRepository<Pregunta, Long> {
    List<Pregunta> findByEvaluacionEvaluacionId(int evaluacionId);
}