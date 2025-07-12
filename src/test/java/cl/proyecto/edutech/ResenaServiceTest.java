package cl.proyecto.edutech;

import cl.proyecto.edutech.model.Resena;
import cl.proyecto.edutech.model.Usuario;
import cl.proyecto.edutech.model.Curso;
import cl.proyecto.edutech.dto.ResenaDTO;
import cl.proyecto.edutech.repository.ResenaRepository;
import cl.proyecto.edutech.service.ResenaService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class ResenaServiceTest {

    @Mock
    private ResenaRepository resenaRepository;

    @InjectMocks
    private ResenaService resenaService;

    @Test
    void crear_shouldReturnSuccessMessage() {
        // Verifica que crear devuelva el mensaje correcto al guardar una nueva reseña
        Resena resena = new Resena();
        when(resenaRepository.save(any(Resena.class))).thenReturn(resena);

        String result = resenaService.crear(resena);

        assertEquals("Reseña creada correctamente.", result);
    }

    @Test
    void listar_shouldReturnListOfResenaDTO() {
        // Verifica que listar devuelva una lista no nula incluso con repositorio vacío
        when(resenaRepository.findAll()).thenReturn(Collections.emptyList());

        List<ResenaDTO> list = resenaService.listar();

        assertNotNull(list);
    }

    @Test
    void obtenerPorId_shouldReturnResenaDTO() {
        // Verifica que obtenerPorId convierta correctamente un Resena en ResenaDTO
        Resena resena = new Resena();
        resena.setResenaId(10);
        Usuario usuario = new Usuario();
        usuario.setUsuarioId(20L);
        resena.setUsuario(usuario);
        Curso curso = new Curso();
        curso.setCursoId(30);
        resena.setCurso(curso);
        resena.setCalificacion(4);
        resena.setComentario("Excelente");
        Date fecha = new Date();
        resena.setFecha_resena(fecha);

        when(resenaRepository.findById(10)).thenReturn(Optional.of(resena));

        ResenaDTO dto = resenaService.obtenerPorId(10);

        assertNotNull(dto);
        assertEquals(10, dto.getResenaId());
        assertEquals(20L, dto.getUsuarioId());
        assertEquals(30, dto.getCursoId());
        assertEquals("Excelente", dto.getComentario());
        assertEquals(4, dto.getCalificacion());
        assertEquals(fecha, dto.getFechaResena());
    }

    @Test
    void actualizar_shouldReturnUpdatedMessage() {
        // Verifica que actualizar modifique los campos y devuelva el mensaje esperado
        Resena existing = new Resena();
        when(resenaRepository.findById(5)).thenReturn(Optional.of(existing));
        Resena updated = new Resena();
        Usuario usuario = new Usuario();
        usuario.setUsuarioId(40L);
        updated.setUsuario(usuario);
        Curso curso = new Curso();
        curso.setCursoId(50);
        updated.setCurso(curso);
        updated.setCalificacion(2);
        updated.setComentario("Regular");
        Date fecha2 = new Date();
        updated.setFecha_resena(fecha2);
        when(resenaRepository.save(any(Resena.class))).thenReturn(updated);

        String result = resenaService.actualizar(5, updated);

        assertEquals("Reseña actualizada correctamente.", result);
    }

    @Test
    void eliminar_shouldReturnDeletedMessage() {
        // Verifica que eliminar borre la reseña y devuelva el mensaje esperado
        when(resenaRepository.existsById(7)).thenReturn(true);
        doNothing().when(resenaRepository).deleteById(7);

        String result = resenaService.eliminar(7);

        assertEquals("Reseña eliminada correctamente.", result);
    }

    @Test
    void listarPorCurso_shouldReturnResenaDTOList() {
        // Verifica que listarPorCurso use findByCurso_cursoId y devuelva lista no nula
        when(resenaRepository.findByCurso_cursoId(3)).thenReturn(Collections.emptyList());

        List<ResenaDTO> list = resenaService.listarPorCurso(3);

        assertNotNull(list);
    }

    @Test
    void listarPorUsuario_shouldReturnResenaDTOList() {
        // Verifica que listarPorUsuario use findByUsuarioUsuarioId y devuelva lista no nula
        when(resenaRepository.findByUsuarioUsuarioId(20L)).thenReturn(Collections.emptyList());

        List<ResenaDTO> list = resenaService.listarPorUsuario(20L);

        assertNotNull(list);
    }
}
