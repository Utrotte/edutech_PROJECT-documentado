package cl.proyecto.edutech.repository; //FRANCISCO RODRIGUEZ

import cl.proyecto.edutech.model.Tarjeta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TarjetaRepository extends JpaRepository<Tarjeta, Long> {
    List<Tarjeta> findByUsuarioUsuarioId(Long usuarioId);
}