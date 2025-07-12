//francisco Rodriguez
package cl.proyecto.edutech.controller;

import cl.proyecto.edutech.model.Pregunta;
import cl.proyecto.edutech.dto.PreguntaDTO;
import cl.proyecto.edutech.service.PreguntaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/preguntas")
public class PreguntaController {

    @Autowired
    private PreguntaService preguntaService;

    @PostMapping
    public String crear(@RequestBody Pregunta pregunta) {
        return preguntaService.crear(pregunta);
    }

    @GetMapping
    public List<PreguntaDTO> listar() {
        return preguntaService.listar();
    }

    @GetMapping("/evaluacion/{evaluacionId}")
    public List<PreguntaDTO> listarPorEvaluacion(@PathVariable int evaluacionId) {
        return preguntaService.listarPorEvaluacion(evaluacionId);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        return preguntaService.eliminar(id);
    }
}
