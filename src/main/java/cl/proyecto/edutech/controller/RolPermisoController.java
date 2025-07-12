package cl.proyecto.edutech.controller;
//Roberto Gonzalez
import cl.proyecto.edutech.model.RolPermiso;
import cl.proyecto.edutech.dto.RolPermisoDTO;
import cl.proyecto.edutech.service.RolPermisoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rolpermisos")
public class RolPermisoController {

    @Autowired
    private RolPermisoService rpService;

    @PostMapping
    public String crear(@RequestBody RolPermiso rp) {
        return rpService.crear(rp);
    }

    @GetMapping
    public List<RolPermisoDTO> listar() {
        return rpService.listar();
    }

    @GetMapping("/rol/{rolId}")
    public List<RolPermisoDTO> listarPorRol(@PathVariable Long rolId) {
        return rpService.listarPorRol(rolId);
    }

    @GetMapping("/permiso/{permisoId}")
    public List<RolPermisoDTO> listarPorPermiso(@PathVariable Long permisoId) {
        return rpService.listarPorPermiso(permisoId);
    }

    @DeleteMapping("/rol/{rolId}")
    public String eliminarPorRol(@PathVariable Long rolId) {
        return rpService.eliminarPorRol(rolId);
    }

    @DeleteMapping("/permiso/{permisoId}")
    public String eliminarPorPermiso(@PathVariable Long permisoId) {
        return rpService.eliminarPorPermiso(permisoId);
    }
}
