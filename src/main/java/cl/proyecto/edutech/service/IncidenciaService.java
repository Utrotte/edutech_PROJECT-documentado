//VICTOR ESPINDOLA
package cl.proyecto.edutech.service;

import cl.proyecto.edutech.model.Incidencia;
import cl.proyecto.edutech.dto.IncidenciaDTO;
import cl.proyecto.edutech.repository.IncidenciaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IncidenciaService {

    @Autowired
    private IncidenciaRepository incidenciaRepo;

    public String crear(Incidencia incidencia) {
        incidenciaRepo.save(incidencia);
        return "Incidencia creada correctamente.";
    }

    public List<IncidenciaDTO> listar() {
        return incidenciaRepo.findAll()
            .stream()
            .map(IncidenciaDTO::new)
            .collect(Collectors.toList());
    }

    public IncidenciaDTO obtenerPorId(int id) {
        return incidenciaRepo.findById(id)
            .map(IncidenciaDTO::new)
            .orElse(null);
    }

    public List<IncidenciaDTO> listarPorUsuario(Long usuarioId) {
        return incidenciaRepo.findByUsuarioUsuarioId(usuarioId)
            .stream()
            .map(IncidenciaDTO::new)
            .collect(Collectors.toList());
    }

    public List<IncidenciaDTO> listarPorEstado(String estado) {
        return incidenciaRepo.findByEstado(estado)
            .stream()
            .map(IncidenciaDTO::new)
            .collect(Collectors.toList());
    }

    public String actualizar(int id, Incidencia incidencia) {
        return incidenciaRepo.findById(id)
            .map(existing -> {
                existing.setDescripcion(incidencia.getDescripcion());
                existing.setEstado(incidencia.getEstado());
                existing.setFecha_reporte(incidencia.getFecha_reporte());
                existing.setUsuario(incidencia.getUsuario());
                incidenciaRepo.save(existing);
                return "Incidencia actualizada correctamente.";
            })
            .orElse("Incidencia no encontrada.");
    }

    public String eliminar(int id) {
        if (incidenciaRepo.existsById(id)) {
            incidenciaRepo.deleteById(id);
            return "Incidencia eliminada correctamente.";
        }
        return "Incidencia no encontrada.";
    }
}
