//FRANCISCO RODRIGUEZ
package cl.proyecto.edutech.dto;

import cl.proyecto.edutech.model.Permiso;

public class PermisoDTO {
    private Long permisoId;
    private String nombrePermiso;
    private String modulo;

    public PermisoDTO() {}

    public PermisoDTO(Permiso permiso) {
        this.permisoId     = permiso.getPermisoId();
        this.nombrePermiso = permiso.getNombrePermiso();
        this.modulo        = permiso.getModulo();
    }

    public Long getPermisoId() {
        return permisoId;
    }

    public void setPermisoId(Long permisoId) {
        this.permisoId = permisoId;
    }

    public String getNombrePermiso() {
        return nombrePermiso;
    }

    public void setNombrePermiso(String nombrePermiso) {
        this.nombrePermiso = nombrePermiso;
    }

    public String getModulo() {
        return modulo;
    }

    public void setModulo(String modulo) {
        this.modulo = modulo;
    }

    
}
