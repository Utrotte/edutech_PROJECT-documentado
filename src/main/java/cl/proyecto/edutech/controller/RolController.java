//Roberto Gonzalez
package cl.proyecto.edutech.controller;

import cl.proyecto.edutech.model.Rol;
import cl.proyecto.edutech.dto.RolDTO;
import cl.proyecto.edutech.service.RolService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RolController {

    @Autowired
    private RolService rolService;

    @PostMapping
    public String crear(@RequestBody Rol rol) {
        return rolService.crear(rol);
    }

    @GetMapping
    public List<RolDTO> listar() {
        return rolService.listar();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> obtener(@PathVariable Long id) {
        RolDTO rolDTO = rolService.obtenerPorId(id);

        if (rolDTO != null) {
            return ResponseEntity.ok(rolDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Rol no encontrado con ID: " + id);
        }
    }
    @PutMapping("/{id}")
    public String actualizar(@PathVariable Long id,
                             @RequestBody Rol rol) {
        return rolService.actualizar(id, rol);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        return rolService.eliminar(id);
    }
}
