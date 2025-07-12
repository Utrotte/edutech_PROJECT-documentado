package cl.proyecto.edutech.repository; //ROBERTO GONZALEZ

import cl.proyecto.edutech.model.MensajeForo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MensajeForoRepository extends JpaRepository<MensajeForo, Long> {
    List<MensajeForo> findByCurso_cursoIdOrderByFechaMensajeDesc(int cursoId);
}