package cl.proyecto.edutech.controller; //VICTOR ESPINDOLA

import cl.proyecto.edutech.model.Curso;
import cl.proyecto.edutech.dto.CursoDTO; 
import cl.proyecto.edutech.service.CursoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus; 
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cursos") 
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping
    public ResponseEntity<String> crear(@RequestBody Curso curso) { 
        String mensaje = cursoService.crear(curso);
        return ResponseEntity.status(HttpStatus.CREATED).body(mensaje);
    }

    @GetMapping
    public ResponseEntity<List<CursoDTO>> listar() { 
        List<Curso> cursos = cursoService.listar(); 
        if (cursos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        List<CursoDTO> cursoDTOs = cursos.stream()
                                       .map(CursoDTO::new) 
                                       .collect(Collectors.toList());
        return ResponseEntity.ok(cursoDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoDTO> obtener(@PathVariable int id) { 
        CursoDTO dto = cursoService.obtenerPorId(id);
        if (dto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/instructor/{instructorId}")
    public ResponseEntity<List<CursoDTO>> listarPorInstructor(@PathVariable Long instructorId) {
        List<CursoDTO> cursoDTOs = cursoService.listarPorInstructor(instructorId);
        if (cursoDTOs.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(cursoDTOs);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizar(@PathVariable int id, @RequestBody Curso curso) { 
        String mensaje = cursoService.actualizar(id, curso);
        if (mensaje.contains("no encontrado")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensaje);
        }
        return ResponseEntity.ok(mensaje);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable int id) {
        String mensaje = cursoService.eliminar(id);
        if (mensaje.contains("no encontrado")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensaje);
        }
        return ResponseEntity.ok(mensaje);
    }
}
