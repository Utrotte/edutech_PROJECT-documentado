package cl.proyecto.edutech;

import cl.proyecto.edutech.model.Usuario;
import cl.proyecto.edutech.dto.UsuarioDTO;
import cl.proyecto.edutech.repository.UsuarioRepository;
import cl.proyecto.edutech.service.UsuarioService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Optional;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepo;

    @InjectMocks
    private UsuarioService usuarioService;

    // Test: crear un usuario con datos válidos
    @Test
    void crear_shouldReturnSuccessMessage() {
        Usuario usuario = new Usuario();
        usuario.setCorreo("correo@ejemplo.com");  // obligatorio
        usuario.setNombre("Carlos");
        usuario.setContrasena("123456");          // obligatorio

        when(usuarioRepo.save(any(Usuario.class))).thenReturn(usuario);

        String result = usuarioService.crear(usuario);
        assertEquals("Usuario creado correctamente.", result);
    }

    // Test: listar usuarios sin error
    @Test
    void listar_shouldReturnListOfUsuario() {
        when(usuarioRepo.findAll()).thenReturn(Collections.emptyList());
        List<Usuario> usuarios = usuarioService.listar();
        assertNotNull(usuarios);
    }

    // Test: obtener un usuario por ID
    @Test
    void obtenerPorId_shouldReturnUsuarioDTO() {
        Usuario usuario = new Usuario();
        usuario.setUsuarioId(1L);
        usuario.setNombre("Ana");
        usuario.setCorreo("ana@correo.com");
        usuario.setContrasena("abc123");

        when(usuarioRepo.findById(1L)).thenReturn(Optional.of(usuario));
        UsuarioDTO dto = usuarioService.obtenerPorId(1L);
        assertNotNull(dto);
        assertEquals("Ana", dto.getNombre());
        assertEquals(1L, dto.getUsuarioId());
    }

    // Test: actualizar usuario existente
    @Test
    void actualizar_shouldReturnUpdatedMessage() {
        Usuario usuario = new Usuario();
        usuario.setUsuarioId(1L);
        usuario.setNombre("Luis");
        usuario.setCorreo("luis@correo.com");
        usuario.setContrasena("clave123");

        when(usuarioRepo.findById(1L)).thenReturn(Optional.of(new Usuario()));
        when(usuarioRepo.save(any(Usuario.class))).thenReturn(usuario);

        String result = usuarioService.actualizar(1L, usuario);
        assertEquals("Usuario actualizado correctamente.", result);
    }

    // Test: desactivar usuario
    @Test
    void desactivar_shouldReturnSuccessMessage() {
        Usuario usuario = new Usuario();
        usuario.setActivo(true);

        when(usuarioRepo.findById(1L)).thenReturn(Optional.of(usuario));
        when(usuarioRepo.save(any(Usuario.class))).thenReturn(usuario);

        String result = usuarioService.desactivar(1L);
        assertEquals("Usuario desactivado correctamente.", result);
    }

    // Test: activar usuario
    @Test
    void activar_shouldReturnSuccessMessage() {
        Usuario usuario = new Usuario();
        usuario.setActivo(false);

        when(usuarioRepo.findById(1L)).thenReturn(Optional.of(usuario));
        when(usuarioRepo.save(any(Usuario.class))).thenReturn(usuario);

        String result = usuarioService.activar(1L);
        assertEquals("Usuario activado correctamente.", result);
    }
}
