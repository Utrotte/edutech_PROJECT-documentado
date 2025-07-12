//francisco Rodriguez
package cl.proyecto.edutech.controller;

import cl.proyecto.edutech.model.Inscripcion;
import cl.proyecto.edutech.dto.InscripcionDTO;
import cl.proyecto.edutech.service.InscripcionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inscripciones")
public class InscripcionController {

    @Autowired
    private InscripcionService inscripcionService;

    @PostMapping
    public String crear(@RequestBody Inscripcion inscripcion) {
        return inscripcionService.crear(inscripcion);
    }

    @GetMapping
    public List<InscripcionDTO> listar() {
        return inscripcionService.listar();
    }

    @GetMapping("/{id}")
    public InscripcionDTO obtener(@PathVariable Long id) {
        return inscripcionService.obtenerPorId(id);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<InscripcionDTO> listarPorUsuario(@PathVariable Long usuarioId) {
        return inscripcionService.listarPorUsuario(usuarioId);
    }

    @GetMapping("/curso/{cursoId}")
    public List<InscripcionDTO> listarPorCurso(@PathVariable int cursoId) {
        return inscripcionService.listarPorCurso(cursoId);
    }

    @GetMapping("/usuario/{usuarioId}/curso/{cursoId}")
    public InscripcionDTO obtenerPorUsuarioYCurso(@PathVariable Long usuarioId,
                                                  @PathVariable int cursoId) {
        return inscripcionService.obtenerPorUsuarioYCurso(usuarioId, cursoId);
    }

    @PutMapping("/{id}")
    public String actualizar(@PathVariable Long id,
                             @RequestBody Inscripcion inscripcion) {
        return inscripcionService.actualizar(id, inscripcion);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        return inscripcionService.eliminar(id);
    }
}
