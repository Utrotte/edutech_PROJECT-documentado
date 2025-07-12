//ROBERTO GONZALEZ
package cl.proyecto.edutech.dto;

import cl.proyecto.edutech.model.RolPermiso;

public class RolPermisoDTO {
    private Long id;
    private Long rolId;
    private Long permisoId;

    public RolPermisoDTO() {}

    public RolPermisoDTO(RolPermiso rp) {
        this.id        = rp.getId();
        this.rolId     = rp.getRol().getRolId();
        this.permisoId = rp.getPermiso().getPermisoId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRolId() {
        return rolId;
    }

    public void setRolId(Long rolId) {
        this.rolId = rolId;
    }

    public Long getPermisoId() {
        return permisoId;
    }

    public void setPermisoId(Long permisoId) {
        this.permisoId = permisoId;
    }

    
}
