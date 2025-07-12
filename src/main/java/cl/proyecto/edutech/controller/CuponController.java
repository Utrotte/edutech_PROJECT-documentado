package cl.proyecto.edutech.controller; //FRANCISCO RODRIGUEZ


import cl.proyecto.edutech.model.Cupon;
import cl.proyecto.edutech.dto.CuponDTO;
import cl.proyecto.edutech.service.CuponService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cupones")
public class CuponController {

    @Autowired
    private CuponService cuponService;

    @PostMapping
    public String crear(@RequestBody Cupon cupon) {
        return cuponService.crear(cupon);
    }

    @GetMapping
    public List<CuponDTO> listar() {
        return cuponService.listar();
    }

    @GetMapping("/{id}")
    public CuponDTO obtener(@PathVariable Long id) {
        return cuponService.obtenerPorId(id);
    }

    @GetMapping("/codigo/{codigo}")
    public CuponDTO obtenerPorCodigo(@PathVariable String codigo) {
        return cuponService.obtenerPorCodigo(codigo);
    }

    @PutMapping("/{id}")
    public String actualizar(@PathVariable Long id,
                             @RequestBody Cupon cupon) {
        return cuponService.actualizar(id, cupon);
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable Long id) {
        return cuponService.eliminar(id);
    }
}
