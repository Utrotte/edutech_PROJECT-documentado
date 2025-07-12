package cl.proyecto.edutech.repository;//FRANCISCO RODRIGUEZ

import cl.proyecto.edutech.model.Persona;
import cl.proyecto.edutech.model.Usuario; // Para buscar por usuario
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
    Optional<Persona> findByRut(String rut);
    Optional<Persona> findByUsuario(Usuario usuario);
    Optional<Persona> findByUsuarioUsuarioId(Long usuarioId);
}