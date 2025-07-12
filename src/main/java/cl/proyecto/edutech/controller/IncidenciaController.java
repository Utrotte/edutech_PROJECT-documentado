//VICTOR ESPINDOLA
package cl.proyecto.edutech.controller;

import cl.proyecto.edutech.model.Incidencia;
import cl.proyecto.edutech.dto.IncidenciaDTO;
import cl.proyecto.edutech.service.IncidenciaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/incidencias")
public class IncidenciaController {

    @Autowired
    private IncidenciaService incidenciaService;

    @PostMapping
    public String crear(@RequestBody Incidencia incidencia) {
        return incidenciaService.crear(incidencia);
    }

    @GetMapping
    public List<IncidenciaDTO> listar() {
        return incidenciaService.listar();
    }

    @GetMapping("/{id}")
    public IncidenciaDTO obtener(@PathVariable int id) {
        return incidenciaService.obtenerPorId(id);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<IncidenciaDTO> listarPorUsuario(@PathVariable Long usuarioId) {
        return incidenciaService.listarPorUsuario(usuarioId);
    }

    @GetMapping("/estado/{estado}")
    public List<IncidenciaDTO> listarPorEstado(@PathVariable String estado) {
        return incidenciaService.listarPorEstado(estado);
    }

    @PutMapping("/{id}")
    public String actualizar(@PathVariable int id,
                             @RequestBody Incidencia incidencia) {
        return incidenciaService.actualizar(id, incidencia);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id) {
        return incidenciaService.eliminar(id);
    }
}
