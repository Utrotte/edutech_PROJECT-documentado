//ROBERTO GONZALEZ
package cl.proyecto.edutech.dto;

import cl.proyecto.edutech.model.Rol;
import java.util.Set;
import java.util.stream.Collectors;

public class RolDTO {
    private Long rolId;
    private String nombreRol;
    private Set<Long> usuarioIds;

    public RolDTO() {}

    public RolDTO(Rol rol) {
        this.rolId      = rol.getRolId();
        this.nombreRol  = rol.getNombreRol();
        this.usuarioIds = rol.getUsuarios()
                              .stream()
                              .map(u -> u.getUsuarioId())
                              .collect(Collectors.toSet());
    }

    public Long getRolId() {
        return rolId;
    }

    public void setRolId(Long rolId) {
        this.rolId = rolId;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }

    public Set<Long> getUsuarioIds() {
        return usuarioIds;
    }

    public void setUsuarioIds(Set<Long> usuarioIds) {
        this.usuarioIds = usuarioIds;
    }

   
}
