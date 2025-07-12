//VICTOR ESPINDOLA
package cl.proyecto.edutech.controller;

import cl.proyecto.edutech.model.Resena;
import cl.proyecto.edutech.dto.ResenaDTO;
import cl.proyecto.edutech.service.ResenaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resenas")
public class ResenaController {

    @Autowired
    private ResenaService resenaService;

    @PostMapping
    public String crear(@RequestBody Resena resena) {
        return resenaService.crear(resena);
    }

    @GetMapping
    public List<ResenaDTO> listar() {
        return resenaService.listar();
    }

    @GetMapping("/{id}")
    public ResenaDTO obtener(@PathVariable int id) {
        return resenaService.obtenerPorId(id);
    }

    @GetMapping("/curso/{cursoId}")
    public List<ResenaDTO> listarPorCurso(@PathVariable int cursoId) {
        return resenaService.listarPorCurso(cursoId);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<ResenaDTO> listarPorUsuario(@PathVariable Long usuarioId) {
        return resenaService.listarPorUsuario(usuarioId);
    }

    @PutMapping("/{id}")
    public String actualizar(@PathVariable int id,
                             @RequestBody Resena resena) {
        return resenaService.actualizar(id, resena);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id) {
        return resenaService.eliminar(id);
    }
}
