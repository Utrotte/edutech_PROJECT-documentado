package cl.proyecto.edutech.controller;
//VICTOR ESPINDOLA
import cl.proyecto.edutech.model.Evaluacion;
import cl.proyecto.edutech.dto.EvaluacionDTO;
import cl.proyecto.edutech.service.EvaluacionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evaluaciones")
public class EvaluacionController {

    @Autowired
    private EvaluacionService evaluacionService;

    @PostMapping
    public String crear(@RequestBody Evaluacion evaluacion) {
        return evaluacionService.crear(evaluacion);
    }

    @GetMapping
    public List<EvaluacionDTO> listar() {
        return evaluacionService.listar();
    }

    @GetMapping("/{id}")
    public EvaluacionDTO obtener(@PathVariable int id) {
        return evaluacionService.obtenerPorId(id);
    }

    @GetMapping("/curso/{cursoId}")
    public List<EvaluacionDTO> listarPorCurso(@PathVariable int cursoId) {
        return evaluacionService.listarPorCurso(cursoId);
    }

    @PutMapping("/{id}")
    public String actualizar(@PathVariable int id,
                             @RequestBody Evaluacion evaluacion) {
        return evaluacionService.actualizar(id, evaluacion);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id) {
        return evaluacionService.eliminar(id);
    }
}
