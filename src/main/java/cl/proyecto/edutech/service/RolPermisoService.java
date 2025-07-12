//Roberto Gonzalez
package cl.proyecto.edutech.service;

import cl.proyecto.edutech.model.RolPermiso;
import cl.proyecto.edutech.dto.RolPermisoDTO;
import cl.proyecto.edutech.repository.RolPermisoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RolPermisoService {

    @Autowired
    private RolPermisoRepository rpRepo;

    public String crear(RolPermiso rp) {
        rpRepo.save(rp);
        return "RolPermiso creado correctamente.";
    }

    public List<RolPermisoDTO> listar() {
        return rpRepo.findAll()
                     .stream()
                     .map(RolPermisoDTO::new)
                     .collect(Collectors.toList());
    }

    public List<RolPermisoDTO> listarPorRol(Long rolId) {
        return rpRepo.findByRol_RolId(rolId)
                     .stream()
                     .map(RolPermisoDTO::new)
                     .collect(Collectors.toList());
    }

    public List<RolPermisoDTO> listarPorPermiso(Long permisoId) {
        return rpRepo.findByPermiso_PermisoId(permisoId)
                     .stream()
                     .map(RolPermisoDTO::new)
                     .collect(Collectors.toList());
    }

    public String eliminarPorRol(Long rolId) {
        rpRepo.deleteByRol_RolId(rolId);
        return "Permisos de rol eliminados.";
    }

    public String eliminarPorPermiso(Long permisoId) {
        rpRepo.deleteByPermiso_PermisoId(permisoId);
        return "Roles con permiso eliminados.";
    }
}
