package cl.proyecto.edutech.model;

//francisco Rodriguez

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "permisos")
public class Permiso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "permiso_id")
    private Long permisoId;
    private String nombrePermiso;
    private String modulo;


    public Permiso() {}


    public Permiso(String nombrePermiso, String modulo) {
        this.nombrePermiso = nombrePermiso;
        this.modulo = modulo;
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
