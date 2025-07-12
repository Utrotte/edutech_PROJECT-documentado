//francisco Rodriguez
package cl.proyecto.edutech.service;

import cl.proyecto.edutech.model.Inscripcion;
import cl.proyecto.edutech.dto.InscripcionDTO;
import cl.proyecto.edutech.repository.InscripcionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InscripcionService {

    @Autowired
    private InscripcionRepository inscripcionRepo;

    public String crear(Inscripcion inscripcion) {
        inscripcionRepo.save(inscripcion);
        return "Inscripción creada correctamente.";
    }

    public List<InscripcionDTO> listar() {
        return inscripcionRepo.findAll()
            .stream()
            .map(InscripcionDTO::new)
            .collect(Collectors.toList());
    }

    public InscripcionDTO obtenerPorId(Long id) {
        return inscripcionRepo.findById(id)
            .map(InscripcionDTO::new)
            .orElse(null);
    }

    public List<InscripcionDTO> listarPorUsuario(Long usuarioId) {
        return inscripcionRepo.findByUsuarioUsuarioId(usuarioId)
            .stream()
            .map(InscripcionDTO::new)
            .collect(Collectors.toList());
    }

    public List<InscripcionDTO> listarPorCurso(int cursoId) {
        return inscripcionRepo.findByCurso_cursoId(cursoId) 
            .stream()
            .map(InscripcionDTO::new)
            .collect(Collectors.toList());
    }

    public InscripcionDTO obtenerPorUsuarioYCurso(Long usuarioId, int cursoId) {
        return inscripcionRepo.findByUsuarioUsuarioIdAndCurso_cursoId(usuarioId, cursoId)
            .map(InscripcionDTO::new)
            .orElse(null);
    }

    public String actualizar(Long id, Inscripcion inscripcion) {
        return inscripcionRepo.findById(id)
            .map(existing -> {
                existing.setUsuario(inscripcion.getUsuario());
                existing.setCurso(inscripcion.getCurso());
                existing.setFechaInscripcion(inscripcion.getFechaInscripcion());
                existing.setProgreso(inscripcion.getProgreso());
                inscripcionRepo.save(existing);
                return "Inscripción actualizada correctamente.";
            })
            .orElse("Inscripción no encontrada.");
    }

    public String eliminar(Long id) {
        if (inscripcionRepo.existsById(id)) {
            inscripcionRepo.deleteById(id);
            return "Inscripción eliminada correctamente.";
        }
        return "Inscripción no encontrada.";
    }
}
