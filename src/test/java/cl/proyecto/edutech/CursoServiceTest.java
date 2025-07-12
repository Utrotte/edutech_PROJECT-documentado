package cl.proyecto.edutech;

import cl.proyecto.edutech.model.Curso;
import cl.proyecto.edutech.dto.CursoDTO;
import cl.proyecto.edutech.repository.CursoRepository;
import cl.proyecto.edutech.repository.InstructorRepository;
import cl.proyecto.edutech.service.CursoService;

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
public class CursoServiceTest {

    @Mock
    private CursoRepository cursoRepository;

    @Mock
    private InstructorRepository instructorRepository;

    @InjectMocks
    private CursoService cursoService;

    // Test que verifica que se pueda crear un curso y retorne el mensaje correspondiente
    @Test
    void crear_shouldReturnSuccessMessage() {
        Curso curso = new Curso();
        when(cursoRepository.save(any(Curso.class))).thenReturn(curso);
        String result = cursoService.crear(curso);
        assertEquals("Curso creado correctamente.", result);
    }

    // Test que verifica que el método listar devuelve una lista (aunque vacía)
    @Test
    void listar_shouldReturnListOfCurso() {
        when(cursoRepository.findAll()).thenReturn(Collections.emptyList());
        List<Curso> cursos = cursoService.listar();
        assertNotNull(cursos);
    }

    // Test que verifica que se puede obtener un CursoDTO desde un ID existente
    @Test
    void obtenerPorId_shouldReturnCursoDTO() {
        Curso curso = new Curso();
        curso.setCursoId(1);
        curso.setTitulo("Java Intermedio");

        when(cursoRepository.findById(1)).thenReturn(Optional.of(curso));
        CursoDTO dto = cursoService.obtenerPorId(1);
        assertNotNull(dto);
        assertEquals("Java Intermedio", dto.getTitulo());
        assertEquals(1, dto.getCursoId());
    }

    // Test que verifica que se pueda actualizar un curso existente correctamente
    @Test
    void actualizar_shouldReturnUpdatedMessage() {
        Curso curso = new Curso();
        curso.setCursoId(1);
        curso.setTitulo("Spring Boot");

        when(cursoRepository.findById(1)).thenReturn(Optional.of(new Curso()));
        when(cursoRepository.save(any(Curso.class))).thenReturn(curso);

        String result = cursoService.actualizar(1, curso);
        assertEquals("Curso actualizado correctamente.", result);
    }

    // Test que verifica que se pueda eliminar un curso por ID, y retorne mensaje de confirmación
    @Test
    void eliminar_shouldReturnDeletedMessage() {
        when(cursoRepository.existsById(1)).thenReturn(true);
        doNothing().when(cursoRepository).deleteById(1);
        String result = cursoService.eliminar(1);
        assertEquals("Curso eliminado correctamente.", result);
    }

    // Test que verifica que se pueda listar cursos filtrando por instructor
    @Test
    void listarPorInstructor_shouldReturnCursoDTOList() {
        when(instructorRepository.existsById(1L)).thenReturn(true);
        when(cursoRepository.findByInstructorInstructorId(1L)).thenReturn(Collections.emptyList());
        List<CursoDTO> cursos = cursoService.listarPorInstructor(1L);
        assertNotNull(cursos);
    }
}
