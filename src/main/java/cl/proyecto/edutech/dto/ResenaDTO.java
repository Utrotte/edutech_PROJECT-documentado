//VICTOR ESPINDOLA
package cl.proyecto.edutech.dto;

import cl.proyecto.edutech.model.Resena;
import java.util.Date;

public class ResenaDTO {
    private int resenaId;
    private Long usuarioId;
    private int cursoId;
    private int calificacion;
    private String comentario;
    private Date fechaResena;

    public ResenaDTO() {}

    public ResenaDTO(Resena resena) {
        this.resenaId     = resena.getResenaId();
        this.usuarioId    = resena.getUsuario().getUsuarioId();
        this.cursoId      = resena.getCurso().getCursoId();
        this.calificacion = resena.getCalificacion();
        this.comentario   = resena.getComentario();
        this.fechaResena  = resena.getFecha_resena();
    }


    public int getResenaId() { return resenaId; }
    public void setResenaId(int resenaId) { this.resenaId = resenaId; }

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }

    public int getCursoId() { return cursoId; }
    public void setCursoId(int cursoId) { this.cursoId = cursoId; }

    public int getCalificacion() { return calificacion; }
    public void setCalificacion(int calificacion) { this.calificacion = calificacion; }

    public String getComentario() { return comentario; }
    public void setComentario(String comentario) { this.comentario = comentario; }

    public Date getFechaResena() { return fechaResena; }
    public void setFechaResena(Date fechaResena) { this.fechaResena = fechaResena; }
}
