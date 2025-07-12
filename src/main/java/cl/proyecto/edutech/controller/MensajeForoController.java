//Roberto Gonzalez

package cl.proyecto.edutech.controller;

import cl.proyecto.edutech.model.MensajeForo;
import cl.proyecto.edutech.dto.MensajeForoDTO;
import cl.proyecto.edutech.service.MensajeForoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mensajesforo")
public class MensajeForoController {

    @Autowired
    private MensajeForoService mensajeService;

    @PostMapping
    public String crear(@RequestBody MensajeForo mensajeForo) {
        return mensajeService.crear(mensajeForo);
    }

    @GetMapping
    public List<MensajeForoDTO> listar() {
        return mensajeService.listar();
    }

    @GetMapping("/curso/{cursoId}")
    public List<MensajeForoDTO> listarPorCurso(@PathVariable int cursoId) {
        return mensajeService.listarPorCurso(cursoId);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        return mensajeService.eliminar(id);
    }
}
