//francisco Rodriguez
package cl.proyecto.edutech.service;

import cl.proyecto.edutech.model.Pregunta;
import cl.proyecto.edutech.dto.PreguntaDTO;
import cl.proyecto.edutech.repository.PreguntaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PreguntaService {

    @Autowired
    private PreguntaRepository preguntaRepo;

    public String crear(Pregunta pregunta) {
        preguntaRepo.save(pregunta);
        return "Pregunta creada correctamente.";
    }

    public List<PreguntaDTO> listar() {
        return preguntaRepo.findAll()
                            .stream()
                            .map(PreguntaDTO::new)
                            .collect(Collectors.toList());
    }

    public List<PreguntaDTO> listarPorEvaluacion(int evaluacionId) {
        return preguntaRepo.findByEvaluacionEvaluacionId(evaluacionId)
                            .stream()
                            .map(PreguntaDTO::new)
                            .collect(Collectors.toList());
    }

    public String eliminar(Long id) {
        preguntaRepo.deleteById(id);
        return "Pregunta eliminada.";
    }
}
