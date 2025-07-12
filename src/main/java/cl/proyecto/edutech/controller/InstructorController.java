//Roberto Gonzalez

package cl.proyecto.edutech.controller;

import cl.proyecto.edutech.model.Instructor;
import cl.proyecto.edutech.dto.InstructorDTO;
import cl.proyecto.edutech.service.InstructorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instructores")
public class InstructorController {

    @Autowired
    private InstructorService instructorService;

    @PostMapping
    public String crear(@RequestBody Instructor instructor) {
        return instructorService.crear(instructor);
    }

    @GetMapping
    public List<InstructorDTO> listar() {
        return instructorService.listar();
    }

    @GetMapping("/{id}")
    public InstructorDTO obtener(@PathVariable Long id) {
        return instructorService.obtenerPorId(id);
    }

    @GetMapping("/usuario/{usuarioId}")
    public InstructorDTO obtenerPorUsuario(@PathVariable Long usuarioId) {
        return instructorService.obtenerPorUsuario(usuarioId);
    }

    @PutMapping("/{id}")
    public String actualizar(@PathVariable Long id,
                             @RequestBody Instructor instructor) {
        return instructorService.actualizar(id, instructor);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        return instructorService.eliminar(id);
    }
}
