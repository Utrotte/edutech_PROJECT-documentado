package cl.proyecto.edutech.repository;//VICTOR ESPINDOLA

import cl.proyecto.edutech.model.Evaluacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EvaluacionRepository extends JpaRepository<Evaluacion, Integer> { 
    List<Evaluacion> findByCurso_cursoId(int cursoId);
}