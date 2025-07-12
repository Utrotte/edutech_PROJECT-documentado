//francisco Rodriguez
package cl.proyecto.edutech.dto;

import cl.proyecto.edutech.model.Inscripcion;
import java.time.LocalDate;

public class InscripcionDTO {
    private Long inscripcionId;
    private Long usuarioId;
    private Integer cursoId;
    private LocalDate fechaInscripcion;
    private Double progreso;

    public InscripcionDTO() {}

    public InscripcionDTO(Inscripcion inscripcion) {
        this.inscripcionId    = inscripcion.getInscripcionId();
        this.usuarioId        = inscripcion.getUsuario().getUsuarioId();
        this.cursoId          = inscripcion.getCurso().getCursoId();
        this.fechaInscripcion = inscripcion.getFechaInscripcion();
        this.progreso         = inscripcion.getProgreso();
    }

   
    public Long getInscripcionId() { return inscripcionId; }
    public void setInscripcionId(Long inscripcionId) { this.inscripcionId = inscripcionId; }

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }

    public Integer getCursoId() { return cursoId; }
    public void setCursoId(Integer cursoId) { this.cursoId = cursoId; }

    public LocalDate getFechaInscripcion() { return fechaInscripcion; }
    public void setFechaInscripcion(LocalDate fechaInscripcion) { this.fechaInscripcion = fechaInscripcion; }

    public Double getProgreso() { return progreso; }
    public void setProgreso(Double progreso) { this.progreso = progreso; }
}
