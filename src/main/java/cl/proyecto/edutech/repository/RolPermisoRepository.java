package cl.proyecto.edutech.repository;//ROBERTO GONZALEZ

import cl.proyecto.edutech.model.RolPermiso;
import cl.proyecto.edutech.model.Rol;
import cl.proyecto.edutech.model.Permiso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RolPermisoRepository extends JpaRepository<RolPermiso, Long> {
    List<RolPermiso> findByRol(Rol rol);
    List<RolPermiso> findByPermiso(Permiso permiso);
    List<RolPermiso> findByRol_RolId(Long rolId);
    List<RolPermiso> findByPermiso_PermisoId(Long permisoId);
    void deleteByRol_RolId(Long rolId);
    void deleteByPermiso_PermisoId(Long permisoId);
}