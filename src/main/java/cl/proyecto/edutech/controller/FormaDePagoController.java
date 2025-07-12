package cl.proyecto.edutech.controller;// FRANCISCO RODRIGUEZ

import cl.proyecto.edutech.model.FormaDePago;
import cl.proyecto.edutech.dto.FormaDePagoDTO;
import cl.proyecto.edutech.service.FormaDePagoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/formasdepago")
public class FormaDePagoController {

    @Autowired
    private FormaDePagoService formaService;

    @PostMapping
    public String crear(@RequestBody FormaDePago formaDePago) {
        return formaService.crear(formaDePago);
    }

    @GetMapping
    public List<FormaDePagoDTO> listar() {
        return formaService.listar();
    }

    @GetMapping("/{id}")
    public FormaDePagoDTO obtener(@PathVariable Integer id) {
        return formaService.obtenerPorId(id);
    }

    @GetMapping("/nombre/{nombre}")
    public FormaDePagoDTO obtenerPorNombre(@PathVariable String nombre) {
        return formaService.obtenerPorNombre(nombre);
    }

    @PutMapping("/{id}")
    public String actualizar(@PathVariable Integer id,
                             @RequestBody FormaDePago formaDePago) {
        return formaService.actualizar(id, formaDePago);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Integer id) {
        return formaService.eliminar(id);
    }
}
