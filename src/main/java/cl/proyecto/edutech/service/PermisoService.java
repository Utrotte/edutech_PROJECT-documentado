//francisco Rodriguez
package cl.proyecto.edutech.service;

import cl.proyecto.edutech.model.Permiso;
import cl.proyecto.edutech.dto.PermisoDTO;
import cl.proyecto.edutech.repository.PermisoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PermisoService {

    @Autowired
    private PermisoRepository permisoRepo;

    public String crear(Permiso permiso) {
        permisoRepo.save(permiso);
        return "Permiso creado correctamente.";
    }

    public List<PermisoDTO> listar() {
        return permisoRepo.findAll()
                      .stream()
                      .map(PermisoDTO::new)
                      .collect(Collectors.toList());
    }

    public PermisoDTO obtenerPorId(Long id) {
        return permisoRepo.findById(id)
                      .map(PermisoDTO::new)
                      .orElse(null);
    }

    public PermisoDTO obtenerPorNombreYModulo(String nombrePermiso, String modulo) {
        return permisoRepo.findByNombrePermisoAndModulo(nombrePermiso, modulo)
                      .map(PermisoDTO::new)
                      .orElse(null);
    }

    public String actualizar(Long id, Permiso permiso) {
        return permisoRepo.findById(id)
            .map(existing -> {
                existing.setNombrePermiso(permiso.getNombrePermiso());
                existing.setModulo(permiso.getModulo());
                permisoRepo.save(existing);
                return "Permiso actualizado correctamente.";
            })
            .orElse("Permiso no encontrado.");
    }

    public String eliminar(Long id) {
        if (permisoRepo.existsById(id)) {
            permisoRepo.deleteById(id);
            return "Permiso eliminado correctamente.";
        }
        return "Permiso no encontrado.";
    }
}
