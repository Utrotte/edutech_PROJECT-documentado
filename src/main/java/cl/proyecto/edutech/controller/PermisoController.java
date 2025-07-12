//francisco Rodriguez
package cl.proyecto.edutech.controller;

import cl.proyecto.edutech.model.Permiso;
import cl.proyecto.edutech.dto.PermisoDTO;
import cl.proyecto.edutech.service.PermisoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permisos")
public class PermisoController {

    @Autowired
    private PermisoService permisoService;

    @PostMapping
    public String crear(@RequestBody Permiso permiso) {
        return permisoService.crear(permiso);
    }

    @GetMapping
    public List<PermisoDTO> listar() {
        return permisoService.listar();
    }

    @GetMapping("/{id}")
    public PermisoDTO obtener(@PathVariable Long id) {
        return permisoService.obtenerPorId(id);
    }

    @GetMapping("/buscar")
    public PermisoDTO buscar(@RequestParam String nombrePermiso,
                             @RequestParam String modulo) {
        return permisoService.obtenerPorNombreYModulo(nombrePermiso, modulo);
    }

    @PutMapping("/{id}")
    public String actualizar(@PathVariable Long id,
                             @RequestBody Permiso permiso) {
        return permisoService.actualizar(id, permiso);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        return permisoService.eliminar(id);
    }
}
