package cl.proyecto.edutech.model;

//francisco Rodriguez

import jakarta.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "preguntas")
public class Pregunta implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long preguntaId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "evaluacion_id", nullable = false)
    private Evaluacion evaluacion;
    private String contenido;

    public Pregunta() {}

    public Pregunta(Evaluacion evaluacion, String contenido) {
        this.evaluacion = evaluacion;
        this.contenido = contenido;
    }

    public Long getPreguntaId() {
        return preguntaId;
    }

    public void setPreguntaId(Long preguntaId) {
        this.preguntaId = preguntaId;
    }

    public Evaluacion getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(Evaluacion evaluacion) {
        this.evaluacion = evaluacion;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
}
