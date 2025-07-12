package cl.proyecto.edutech.dto; //ROBERTO GONZALEZ

import cl.proyecto.edutech.model.MensajeForo;
import java.time.LocalDateTime;

public class MensajeForoDTO {
    private Long mensajeId;
    private Integer cursoId;
    private Long usuarioId;
    private String contenido;
    private LocalDateTime fechaMensaje;

    public MensajeForoDTO() {}

    public MensajeForoDTO(MensajeForo mf) {
        this.mensajeId   = mf.getMensajeId();
        this.cursoId     = mf.getCurso().getCursoId();
        this.usuarioId   = mf.getUsuario().getUsuarioId();
        this.contenido   = mf.getContenido();
        this.fechaMensaje= mf.getFechaMensaje();
    }

    public Long getMensajeId() {
        return mensajeId;
    }

    public void setMensajeId(Long mensajeId) {
        this.mensajeId = mensajeId;
    }

    public Integer getCursoId() {
        return cursoId;
    }

    public void setCursoId(Integer cursoId) {
        this.cursoId = cursoId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public LocalDateTime getFechaMensaje() {
        return fechaMensaje;
    }

    public void setFechaMensaje(LocalDateTime fechaMensaje) {
        this.fechaMensaje = fechaMensaje;
    }

    
}
