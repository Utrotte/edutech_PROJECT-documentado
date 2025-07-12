// victor espindola
package cl.proyecto.edutech.dto;

import cl.proyecto.edutech.model.Incidencia;
import java.util.Date;

public class IncidenciaDTO {
    private int incidenciaId;
    private Long usuarioId;
    private String descripcion;
    private String estado;
    private Date fechaReporte;

    public IncidenciaDTO() {}

    public IncidenciaDTO(Incidencia incidencia) {
        this.incidenciaId  = incidencia.getIncidenciaId();
        this.usuarioId     = incidencia.getUsuario().getUsuarioId();
        this.descripcion   = incidencia.getDescripcion();
        this.estado        = incidencia.getEstado();
        this.fechaReporte  = incidencia.getFecha_reporte();
    }

    
    public int getIncidenciaId() { return incidenciaId; }
    public void setIncidenciaId(int incidenciaId) { this.incidenciaId = incidenciaId; }

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public Date getFechaReporte() { return fechaReporte; }
    public void setFechaReporte(Date fechaReporte) { this.fechaReporte = fechaReporte; }
}
