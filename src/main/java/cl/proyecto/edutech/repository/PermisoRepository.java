package cl.proyecto.edutech.repository;//FRANCISCO RODRIGUEZ

import cl.proyecto.edutech.model.Permiso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PermisoRepository extends JpaRepository<Permiso, Long> {
    Optional<Permiso> findByNombrePermiso(String nombrePermiso);
    Optional<Permiso> findByNombrePermisoAndModulo(String nombrePermiso, String modulo); 
}