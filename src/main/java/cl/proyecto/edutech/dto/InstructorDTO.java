package cl.proyecto.edutech.dto; //ROBERTO GONZALEZ

import cl.proyecto.edutech.model.Instructor;
import java.util.Set;
import java.util.stream.Collectors;

public class InstructorDTO {
    private Long instructorId;
    private Long usuarioId;
    private String especialidad;
    private Set<Integer> cursosIds;

    public InstructorDTO() {}

    public InstructorDTO(Instructor i) {
        this.instructorId  = i.getInstructorId();
        this.usuarioId     = i.getUsuario().getUsuarioId();
        this.especialidad  = i.getEspecialidad();
        this.cursosIds     = i.getCursosImpartidos()
                               .stream()
                               .map(c -> c.getCursoId())
                               .collect(Collectors.toSet());
    }

    public Long getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Long instructorId) {
        this.instructorId = instructorId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public Set<Integer> getCursosIds() {
        return cursosIds;
    }

    public void setCursosIds(Set<Integer> cursosIds) {
        this.cursosIds = cursosIds;
    }
    
}
