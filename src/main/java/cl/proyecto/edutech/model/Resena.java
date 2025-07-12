package cl.proyecto.edutech.model;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;

//VE
@Entity
public class Resena {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int resenaId;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;
    private int calificacion;
    private String comentario;

    @Temporal(TemporalType.DATE)
    private Date fecha_resena;

    public Resena() {
        this.resenaId = 0;
        this.usuario = null;
        this.curso = null;
        this.calificacion = 0;
        this.comentario = "";
        this.fecha_resena = new Date();
    }

    public int getResenaId() {
        return resenaId;
    }

    public void setResenaId(int resenaId) {
        this.resenaId = resenaId;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFecha_resena() {
        return fecha_resena;
    }

    public void setFecha_resena(Date fecha_resena) {
        this.fecha_resena = fecha_resena;
    }
}
