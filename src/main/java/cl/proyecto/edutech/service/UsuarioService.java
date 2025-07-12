//Roberto Gonzalez
package cl.proyecto.edutech.service;

import cl.proyecto.edutech.model.Persona;
import cl.proyecto.edutech.model.Usuario;
import cl.proyecto.edutech.dto.UsuarioDTO;
import cl.proyecto.edutech.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepo;

    public String crear(Usuario usuario) {
        if (usuario.getCorreo() == null || usuario.getCorreo().isBlank()) {
            return "El correo es obligatorio.";
        }
        if (usuario.getContrasena() == null || usuario.getContrasena().isBlank()) {
            return "La contraseña es obligatoria.";
        }
        if (usuarioRepo.findByCorreo(usuario.getCorreo()).isPresent()) {
            return "El correo ya está registrado.";
        }
        usuario.setFechaRegistro(LocalDateTime.now());
        usuario.setActivo(true);

            if (usuario.getPersona() != null) {
            Persona persona = usuario.getPersona();
            persona.setUsuario(usuario); // pone el Usuario en Persona
        }
        usuarioRepo.save(usuario);
        return "Usuario creado correctamente.";
    }

    public List<Usuario> listar() {
        return usuarioRepo.findAll();
    }

    public UsuarioDTO obtenerPorId(Long id) {
        return usuarioRepo.findById(id)
                          .map(UsuarioDTO::new)
                          .orElse(null);
    }

  public String actualizar(Long id, Usuario usuarioInfoRequest) {
        return usuarioRepo.findById(id)
            .map(existingUsuario -> {
                existingUsuario.setNombre(usuarioInfoRequest.getNombre());
                existingUsuario.setContrasena(usuarioInfoRequest.getContrasena());
                existingUsuario.setActivo(usuarioInfoRequest.getActivo());
                existingUsuario.setRol(usuarioInfoRequest.getRol());
                Persona personaDelRequest = usuarioInfoRequest.getPersona();

                if (personaDelRequest != null) {
                    personaDelRequest.setUsuario(existingUsuario); 
                    existingUsuario.setPersona(personaDelRequest); 
                } else {
                    if (existingUsuario.getPersona() != null) {
                        existingUsuario.setPersona(null);
                    }
                }
                usuarioRepo.save(existingUsuario);
                return "Usuario actualizado correctamente.";
            })
            .orElse("Usuario no encontrado.");
    }

    public String desactivar(Long id) {
        Optional<Usuario> usuarioOptional = usuarioRepo.findById(id);

        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            if (usuario.getActivo()) {
                usuario.setActivo(false);
                usuarioRepo.save(usuario);
                return "Usuario desactivado correctamente.";
            } else {
                return "El usuario ya se encontraba inactivo.";
            }
        } else {
            return "Usuario no encontrado.";
        }
    }

        public String activar(Long id) {
        Optional<Usuario> usuarioOptional = usuarioRepo.findById(id);

        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            if (!usuario.getActivo()) {
                usuario.setActivo(true);
                usuarioRepo.save(usuario);
                return "Usuario activado correctamente.";
            } else {
                return "El usuario ya se encontraba activo.";
            }
        } else {
            return "Usuario no encontrado.";
        }
    }
}