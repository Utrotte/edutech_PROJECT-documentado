package cl.proyecto.edutech.repository;//VICTOR ESPINDOLA

import cl.proyecto.edutech.model.Resena;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ResenaRepository extends JpaRepository<Resena, Integer> {
    List<Resena> findByCurso_cursoId(int cursoId);

    List<Resena> findByUsuarioUsuarioId(Long usuarioId);
}