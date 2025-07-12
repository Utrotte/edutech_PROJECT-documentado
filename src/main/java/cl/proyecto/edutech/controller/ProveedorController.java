//VICTOR ESPINDOLA
package cl.proyecto.edutech.controller;

import cl.proyecto.edutech.model.Proveedor;
import cl.proyecto.edutech.dto.ProveedorDTO;
import cl.proyecto.edutech.service.ProveedorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proveedores")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorService;

    @PostMapping
    public String crear(@RequestBody Proveedor proveedor) {
        return proveedorService.crear(proveedor);
    }

    @GetMapping
    public List<ProveedorDTO> listar() {
        return proveedorService.listar();
    }

    @GetMapping("/{id}")
    public ProveedorDTO obtener(@PathVariable int id) {
        return proveedorService.obtenerPorId(id);
    }

    @GetMapping("/nombre/{nombre}")
    public ProveedorDTO obtenerPorNombre(@PathVariable String nombre) {
        return proveedorService.obtenerPorNombre(nombre);
    }

    @PutMapping("/{id}")
    public String actualizar(@PathVariable int id,
                             @RequestBody Proveedor proveedor) {
        return proveedorService.actualizar(id, proveedor);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable int id) {
        return proveedorService.eliminar(id);
    }
}
