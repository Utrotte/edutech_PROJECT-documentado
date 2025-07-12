package cl.proyecto.edutech.dto;
//Victor Espindola
import cl.proyecto.edutech.model.Curso;

import cl.proyecto.edutech.model.Usuario;     
import java.time.LocalDate;

public class CursoDTO {
    private int cursoId;
    private String titulo;
    private String descripcion;
    private Long instructorId;
    private String instructorNombre;
    private LocalDate fechaPublicacion;
    private String estado;

    public CursoDTO() {}

    public CursoDTO(Curso curso) {
        this.cursoId = curso.getCursoId();
        this.titulo = curso.getTitulo();
        this.descripcion = curso.getDescripcion();
        if (curso.getInstructor() != null) {
            this.instructorId = curso.getInstructor().getInstructorId();
            Usuario instructorUsuario = curso.getInstructor().getUsuario();
            if (instructorUsuario != null) {
                this.instructorNombre = instructorUsuario.getNombre();
            }
        }
        this.fechaPublicacion = curso.getFechaPublicacion();
        this.estado = curso.getEstado();
    }


    public int getCursoId() { return cursoId; }
    public void setCursoId(int cursoId) { this.cursoId = cursoId; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
    public Long getInstructorId() { return instructorId; }
    public void setInstructorId(Long instructorId) { this.instructorId = instructorId; }
    public String getInstructorNombre() { return instructorNombre; }
    public void setInstructorNombre(String instructorNombre) { this.instructorNombre = instructorNombre; }
    public LocalDate getFechaPublicacion() { return fechaPublicacion; }
    public void setFechaPublicacion(LocalDate fechaPublicacion) { this.fechaPublicacion = fechaPublicacion; }
    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}