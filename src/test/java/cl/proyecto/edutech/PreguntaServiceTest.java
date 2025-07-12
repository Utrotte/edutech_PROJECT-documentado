package cl.proyecto.edutech;

import cl.proyecto.edutech.model.Pregunta;
import cl.proyecto.edutech.dto.PreguntaDTO;
import cl.proyecto.edutech.repository.PreguntaRepository;
import cl.proyecto.edutech.service.PreguntaService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class PreguntaServiceTest {

    @Mock
    private PreguntaRepository preguntaRepo;

    @InjectMocks
    private PreguntaService preguntaService;

    // Test: crear pregunta
    @Test
    void crear_shouldReturnSuccessMessage() {
        Pregunta pregunta = new Pregunta();
        when(preguntaRepo.save(any(Pregunta.class))).thenReturn(pregunta);
        String result = preguntaService.crear(pregunta);
        assertEquals("Pregunta creada correctamente.", result);
    }

    // Test: listar preguntas
    @Test
    void listar_shouldReturnListOfPreguntaDTO() {
        when(preguntaRepo.findAll()).thenReturn(Collections.emptyList());
        List<PreguntaDTO> preguntas = preguntaService.listar();
        assertNotNull(preguntas);
    }

    // Test: listar preguntas por evaluación
    @Test
    void listarPorEvaluacion_shouldReturnPreguntaDTOList() {
        when(preguntaRepo.findByEvaluacionEvaluacionId(1)).thenReturn(Collections.emptyList());
        List<PreguntaDTO> preguntas = preguntaService.listarPorEvaluacion(1);
        assertNotNull(preguntas);
    }

    // Test: eliminar pregunta
    @Test
    void eliminar_shouldReturnDeletedMessage() {
        when(preguntaRepo.existsById(1L)).thenReturn(true);
        doNothing().when(preguntaRepo).deleteById(1L);
        String result = preguntaService.eliminar(1L);
        assertEquals("Pregunta eliminada.", result); // Texto corregido según implementación real
    }
}
