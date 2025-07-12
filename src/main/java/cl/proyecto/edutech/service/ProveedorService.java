//VICTOR ESPINDOLA
package cl.proyecto.edutech.service;

import cl.proyecto.edutech.model.Proveedor;
import cl.proyecto.edutech.dto.ProveedorDTO;
import cl.proyecto.edutech.repository.ProveedorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepo;

    public String crear(Proveedor proveedor) {
        proveedorRepo.save(proveedor);
        return "Proveedor creado correctamente.";
    }

    public List<ProveedorDTO> listar() {
        return proveedorRepo.findAll()
                            .stream()
                            .map(ProveedorDTO::new)
                            .collect(Collectors.toList());
    }

    public ProveedorDTO obtenerPorId(int id) {
        return proveedorRepo.findById(id)
                            .map(ProveedorDTO::new)
                            .orElse(null);
    }

    public ProveedorDTO obtenerPorNombre(String nombre) {
        return proveedorRepo.findByNombre(nombre)
                            .map(ProveedorDTO::new)
                            .orElse(null);
    }

    public String actualizar(int id, Proveedor proveedor) {
        return proveedorRepo.findById(id)
            .map(existing -> {
                existing.setNombre(proveedor.getNombre());
                existing.setContacto(proveedor.getContacto());
                proveedorRepo.save(existing);
                return "Proveedor actualizado correctamente.";
            })
            .orElse("Proveedor no encontrado.");
    }

    public String eliminar(int id) {
        if (proveedorRepo.existsById(id)) {
            proveedorRepo.deleteById(id);
            return "Proveedor eliminado correctamente.";
        }
        return "Proveedor no encontrado.";
    }
}
