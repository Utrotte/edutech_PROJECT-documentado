//FRANCISCO RODRIGUEZ
package cl.proyecto.edutech.dto;

import cl.proyecto.edutech.model.Respuesta;

public class RespuestaDTO {
    private Long respuestaId;
    private Long preguntaId;
    private String contenido;
    private Boolean correcta;

    public RespuestaDTO() {}

    public RespuestaDTO(Respuesta r) {
        this.respuestaId = r.getRespuestaId();
        this.preguntaId  = r.getPregunta().getPreguntaId();
        this.contenido   = r.getContenido();
        this.correcta    = r.getCorrecta();
    }

    public Long getRespuestaId() {
        return respuestaId;
    }

    public void setRespuestaId(Long respuestaId) {
        this.respuestaId = respuestaId;
    }

    public Long getPreguntaId() {
        return preguntaId;
    }

    public void setPreguntaId(Long preguntaId) {
        this.preguntaId = preguntaId;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Boolean getCorrecta() {
        return correcta;
    }

    public void setCorrecta(Boolean correcta) {
        this.correcta = correcta;
    }

    
}
