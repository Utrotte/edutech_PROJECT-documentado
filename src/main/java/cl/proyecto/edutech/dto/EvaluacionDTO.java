//VICTOR ESPINDOLA
package cl.proyecto.edutech.dto;

import cl.proyecto.edutech.model.Evaluacion;
import java.util.Date;

public class EvaluacionDTO {
    private int evaluacionId;
    private String titulo;
    private int cursoId;
    private Date fechaCreacion;

    public EvaluacionDTO() {}

    public EvaluacionDTO(Evaluacion evaluacion) {
        this.evaluacionId = evaluacion.getEvaluacionId();
        this.titulo       = evaluacion.getTitulo();
        this.cursoId      = evaluacion.getCurso().getCursoId();
        this.fechaCreacion= evaluacion.getFecha_creacion();
    }

  
    public int getEvaluacionId() { return evaluacionId; }
    public void setEvaluacionId(int evaluacionId) { this.evaluacionId = evaluacionId; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public int getCursoId() { return cursoId; }
    public void setCursoId(int cursoId) { this.cursoId = cursoId; }

    public Date getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(Date fechaCreacion) { this.fechaCreacion = fechaCreacion; }
}
