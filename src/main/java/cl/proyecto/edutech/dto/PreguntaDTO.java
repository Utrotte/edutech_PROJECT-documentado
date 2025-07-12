//FRANCISCO RODRIGUEZ
package cl.proyecto.edutech.dto;

import cl.proyecto.edutech.model.Pregunta;

public class PreguntaDTO {
    private Long preguntaId;
    private int evaluacionId;
    private String contenido;

    public PreguntaDTO() {}

    public PreguntaDTO(Pregunta p) {
        this.preguntaId   = p.getPreguntaId();
        this.evaluacionId = p.getEvaluacion().getEvaluacionId();
        this.contenido    = p.getContenido();
    }

    public Long getPreguntaId() {
        return preguntaId;
    }

    public void setPreguntaId(Long preguntaId) {
        this.preguntaId = preguntaId;
    }

    public int getEvaluacionId() {
        return evaluacionId;
    }

    public void setEvaluacionId(int evaluacionId) {
        this.evaluacionId = evaluacionId;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

   
}
