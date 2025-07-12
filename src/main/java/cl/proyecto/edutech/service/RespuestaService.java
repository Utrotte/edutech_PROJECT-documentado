//francisco Rodriguez
package cl.proyecto.edutech.service;

import cl.proyecto.edutech.model.Respuesta;
import cl.proyecto.edutech.dto.RespuestaDTO;
import cl.proyecto.edutech.repository.RespuestaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RespuestaService {

    @Autowired
    private RespuestaRepository respuestaRepo;

    public String crear(Respuesta respuesta) {
        respuestaRepo.save(respuesta);
        return "Respuesta creada correctamente.";
    }

    public List<RespuestaDTO> listar() {
        return respuestaRepo.findAll()
                            .stream()
                            .map(RespuestaDTO::new)
                            .collect(Collectors.toList());
    }

    public List<RespuestaDTO> listarPorPregunta(Long preguntaId) {
        return respuestaRepo.findByPreguntaPreguntaId(preguntaId)
                            .stream()
                            .map(RespuestaDTO::new)
                            .collect(Collectors.toList());
    }

    public String eliminar(Long id) {
        respuestaRepo.deleteById(id);
        return "Respuesta eliminada.";
    }
}
