//Victor E
package cl.proyecto.edutech.service;

import cl.proyecto.edutech.model.Evaluacion;
import cl.proyecto.edutech.dto.EvaluacionDTO;
import cl.proyecto.edutech.repository.EvaluacionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EvaluacionService {

    @Autowired
    private EvaluacionRepository evaluacionRepo;

    public String crear(Evaluacion evaluacion) {
        evaluacionRepo.save(evaluacion);
        return "Evaluación creada correctamente.";
    }

    public List<EvaluacionDTO> listar() {
        return evaluacionRepo.findAll()
            .stream()
            .map(EvaluacionDTO::new)
            .collect(Collectors.toList());
    }

    public EvaluacionDTO obtenerPorId(int id) {
        return evaluacionRepo.findById(id)
            .map(EvaluacionDTO::new)
            .orElse(null);
    }

    public List<EvaluacionDTO> listarPorCurso(int cursoId) {
        return evaluacionRepo.findByCurso_cursoId(cursoId)
            .stream()
            .map(EvaluacionDTO::new)
            .collect(Collectors.toList());
    }

    public String actualizar(int id, Evaluacion evaluacion) {
        return evaluacionRepo.findById(id)
            .map(existing -> {
                existing.setTitulo(evaluacion.getTitulo());
                existing.setCurso(evaluacion.getCurso());
                existing.setFecha_creacion(evaluacion.getFecha_creacion());
                evaluacionRepo.save(existing);
                return "Evaluación actualizada correctamente.";
            })
            .orElse("Evaluación no encontrada.");
    }

    public String eliminar(int id) {
        if (evaluacionRepo.existsById(id)) {
            evaluacionRepo.deleteById(id);
            return "Evaluación eliminada correctamente.";
        }
        return "Evaluación no encontrada.";
    }
}
