package cl.proyecto.edutech.repository; //FRANCISCO RODRIGUEZ

import cl.proyecto.edutech.model.Respuesta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {
    List<Respuesta> findByPreguntaPreguntaId(Long preguntaId);
}