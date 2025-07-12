//VICTOR ESPINDOLA
package cl.proyecto.edutech.dto;

import cl.proyecto.edutech.model.Proveedor;

public class ProveedorDTO {
    private int proveedorId;
    private String nombre;
    private String contacto;

    public ProveedorDTO() {}

    public ProveedorDTO(Proveedor p) {
        this.proveedorId = p.getProveedorId();
        this.nombre      = p.getNombre();
        this.contacto    = p.getContacto();
    }

    public int getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(int proveedorId) {
        this.proveedorId = proveedorId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    
}
