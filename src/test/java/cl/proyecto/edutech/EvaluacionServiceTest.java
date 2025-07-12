package cl.proyecto.edutech;

import cl.proyecto.edutech.model.Evaluacion;
import cl.proyecto.edutech.model.Curso;
import cl.proyecto.edutech.dto.EvaluacionDTO;
import cl.proyecto.edutech.repository.EvaluacionRepository;
import cl.proyecto.edutech.service.EvaluacionService;

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
public class EvaluacionServiceTest {

    @Mock
    private EvaluacionRepository evaluacionRepo;

    @InjectMocks
    private EvaluacionService evaluacionService;

    // Test: crear una evaluación
    @Test
    void crear_shouldReturnSuccessMessage() {
        Evaluacion evaluacion = new Evaluacion();
        evaluacion.setTitulo("Prueba Unidad 1");

        when(evaluacionRepo.save(any(Evaluacion.class))).thenReturn(evaluacion);
        String result = evaluacionService.crear(evaluacion);
        assertEquals("Evaluación creada correctamente.", result);
    }

    // Test: listar evaluaciones
    @Test
    void listar_shouldReturnListOfEvaluacionDTO() {
        when(evaluacionRepo.findAll()).thenReturn(Collections.emptyList());
        List<EvaluacionDTO> lista = evaluacionService.listar();
        assertNotNull(lista);
    }

    // Test: obtener evaluación por ID, con curso asociado para evitar NullPointerException
    @Test
    void obtenerPorId_shouldReturnEvaluacionDTO() {
        Curso curso = new Curso();
        curso.setCursoId(10); // ID de curso ficticio

        Evaluacion evaluacion = new Evaluacion();
        evaluacion.setEvaluacionId(1);
        evaluacion.setTitulo("Control de lectura");
        evaluacion.setCurso(curso); // Asociación necesaria

        when(evaluacionRepo.findById(1)).thenReturn(Optional.of(evaluacion));
        EvaluacionDTO dto = evaluacionService.obtenerPorId(1);

        assertNotNull(dto);
        assertEquals("Control de lectura", dto.getTitulo());
        assertEquals(1, dto.getEvaluacionId());
        assertEquals(10, dto.getCursoId());
    }

    // Test: actualizar evaluación existente
    @Test
    void actualizar_shouldReturnUpdatedMessage() {
        Evaluacion evaluacion = new Evaluacion();
        evaluacion.setEvaluacionId(1);
        evaluacion.setTitulo("Examen Final");

        when(evaluacionRepo.findById(1)).thenReturn(Optional.of(new Evaluacion()));
        when(evaluacionRepo.save(any(Evaluacion.class))).thenReturn(evaluacion);

        String result = evaluacionService.actualizar(1, evaluacion);
        assertEquals("Evaluación actualizada correctamente.", result);
    }

    // Test: eliminar evaluación por ID
    @Test
    void eliminar_shouldReturnDeletedMessage() {
        when(evaluacionRepo.existsById(1)).thenReturn(true);
        doNothing().when(evaluacionRepo).deleteById(1);

        String result = evaluacionService.eliminar(1);
        assertEquals("Evaluación eliminada correctamente.", result);
    }

    // Test: listar evaluaciones por curso
    @Test
    void listarPorCurso_shouldReturnEvaluacionDTOList() {
        when(evaluacionRepo.findByCurso_cursoId(1)).thenReturn(Collections.emptyList());
        List<EvaluacionDTO> evaluaciones = evaluacionService.listarPorCurso(1);
        assertNotNull(evaluaciones);
    }
}
