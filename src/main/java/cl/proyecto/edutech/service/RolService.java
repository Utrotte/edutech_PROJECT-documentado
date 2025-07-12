//Roberto Gonzalez
package cl.proyecto.edutech.service;

import cl.proyecto.edutech.model.Rol;
import cl.proyecto.edutech.dto.RolDTO;
import cl.proyecto.edutech.repository.RolRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RolService {

    @Autowired
    private RolRepository rolRepo;

    public String crear(Rol rol) {
        rolRepo.save(rol);
        return "Rol creado correctamente.";
    }

    public List<RolDTO> listar() {
        return rolRepo.findAll()
                      .stream()
                      .map(RolDTO::new)
                      .collect(Collectors.toList());
    }

    public RolDTO obtenerPorId(Long id) {
        return rolRepo.findById(id)
                      .map(RolDTO::new)
                      .orElse(null);
    }

    public String actualizar(Long id, Rol rol) {
        return rolRepo.findById(id)
            .map(existing -> {
                existing.setNombreRol(rol.getNombreRol());
                rolRepo.save(existing);
                return "Rol actualizado correctamente.";
            })
            .orElse("Rol no encontrado.");
    }

    public String eliminar(Long id) {
        if (rolRepo.existsById(id)) {
            rolRepo.deleteById(id);
            return "Rol eliminado correctamente.";
        }
        return "Rol no encontrado.";
    }
}
