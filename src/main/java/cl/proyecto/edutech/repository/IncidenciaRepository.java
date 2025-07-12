package cl.proyecto.edutech.repository;// victor espindola

import cl.proyecto.edutech.model.Incidencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IncidenciaRepository extends JpaRepository<Incidencia, Integer> {
    List<Incidencia> findByUsuarioUsuarioId(Long usuarioId);
    List<Incidencia> findByEstado(String estado);
}