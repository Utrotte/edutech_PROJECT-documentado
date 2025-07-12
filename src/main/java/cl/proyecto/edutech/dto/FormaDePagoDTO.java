// victor espindola
package cl.proyecto.edutech.dto;

import cl.proyecto.edutech.model.FormaDePago;

public class FormaDePagoDTO {
    private Integer id;
    private String nombre;
    private String descripcion;

    public FormaDePagoDTO() {}

    public FormaDePagoDTO(FormaDePago formaDePago) {
        this.id          = formaDePago.getId();
        this.nombre      = formaDePago.getNombre();
        this.descripcion = formaDePago.getDescripcion();
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
