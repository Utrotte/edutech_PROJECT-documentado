package cl.proyecto.edutech.model;

//Roberto Gonzalez

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.CascadeType;
import java.util.Set;
import java.util.HashSet;

@Entity
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long instructorId;
    private String especialidad;

    @OneToOne
    @JoinColumn(name = "usuario_id", nullable = false, unique = true)
    private Usuario usuario;

    @OneToMany(mappedBy = "instructor", cascade = CascadeType.PERSIST)
    private Set<Curso> cursosImpartidos = new HashSet<>();

    public Instructor() {
    }

    public Instructor(Usuario usuario, String especialidad) {
        this.usuario = usuario;
        this.especialidad = especialidad;
    }

    public Long getInstructorId() {
        return instructorId;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Set<Curso> getCursosImpartidos() {
        return cursosImpartidos;
    }

    public void setCursosImpartidos(Set<Curso> cursosImpartidos) {
        this.cursosImpartidos = cursosImpartidos;
    }

    public void addCursoImpartido(Curso curso) {
        this.cursosImpartidos.add(curso);
        curso.setInstructor(this);
    }

    public void removeCursoImpartido(Curso curso) {
        this.cursosImpartidos.remove(curso);
        curso.setInstructor(null);
    }
}