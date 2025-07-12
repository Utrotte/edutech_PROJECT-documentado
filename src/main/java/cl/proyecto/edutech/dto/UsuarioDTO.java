//ROBERTO GONZALEZ
package cl.proyecto.edutech.dto;

import cl.proyecto.edutech.model.Usuario;
import cl.proyecto.edutech.model.Rol;       
import cl.proyecto.edutech.model.Persona;  
import java.time.LocalDateTime;

public class UsuarioDTO {
    private Long usuarioId;
    private String nombre;
    private String correo;
    private Boolean activo;
    private LocalDateTime fechaRegistro;
    private String rolNombre;
    private Long personaId;

    public UsuarioDTO() {}

    public UsuarioDTO(Usuario usuario) {
        this.usuarioId = usuario.getUsuarioId();
        this.nombre = usuario.getNombre();
        this.correo = usuario.getCorreo();
        this.activo = usuario.getActivo();
        this.fechaRegistro = usuario.getFechaRegistro();

        Rol rol = usuario.getRol();
        if (rol != null) {
            this.rolNombre = rol.getNombreRol();
        } else {
            this.rolNombre = null;
        }

        Persona persona = usuario.getPersona();
        if (persona != null) {
            this.personaId = persona.getPersonaId();
        } else {
            this.personaId = null;
        }
    }

    public Long getUsuarioId() {
        return usuarioId;
    }
    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) { this.correo = correo; }
    public Boolean getActivo() { return activo; }
    public void setActivo(Boolean activo) { this.activo = activo; }
    public LocalDateTime getFechaRegistro() { return fechaRegistro; }
    public void setFechaRegistro(LocalDateTime fechaRegistro) { this.fechaRegistro = fechaRegistro; }
    public String getRolNombre() { return rolNombre; }
    public void setRolNombre(String rolNombre) { this.rolNombre = rolNombre; }
    public Long getPersonaId() { return personaId; }
    public void setPersonaId(Long personaId) { this.personaId = personaId; }
}
