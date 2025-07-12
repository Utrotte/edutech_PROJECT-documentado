package cl.proyecto.edutech;

import cl.proyecto.edutech.model.Cupon;
import cl.proyecto.edutech.dto.CuponDTO;
import cl.proyecto.edutech.repository.CuponRepository;
import cl.proyecto.edutech.service.CuponService;

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
public class CuponServiceTest {

    @Mock
    private CuponRepository cuponRepo;

    @InjectMocks
    private CuponService cuponService;

    // Test: crear cupón
    @Test
    void crear_shouldReturnSuccessMessage() {
        Cupon cupon = new Cupon();
        when(cuponRepo.save(any(Cupon.class))).thenReturn(cupon);
        String result = cuponService.crear(cupon);
        assertEquals("Cupón creado correctamente.", result);
    }

    // Test: listar cupones
    @Test
    void listar_shouldReturnListOfCuponDTO() {
        when(cuponRepo.findAll()).thenReturn(Collections.emptyList());
        List<CuponDTO> cupones = cuponService.listar();
        assertNotNull(cupones);
    }

    // Test: obtener cupón por ID
    @Test
    void obtenerPorId_shouldReturnCuponDTO() {
        Cupon cupon = new Cupon();
        cupon.setCodigo("DESC10");

        when(cuponRepo.findById(1L)).thenReturn(Optional.of(cupon));
        CuponDTO dto = cuponService.obtenerPorId(1L);

        assertNotNull(dto);
        assertEquals("DESC10", dto.getCodigo());
    }

    // Test: obtener cupón por código
    @Test
    void obtenerPorCodigo_shouldReturnCuponDTO() {
        Cupon cupon = new Cupon();
        cupon.setCodigo("VERANO15");

        when(cuponRepo.findByCodigo("VERANO15")).thenReturn(Optional.of(cupon));
        CuponDTO dto = cuponService.obtenerPorCodigo("VERANO15");

        assertNotNull(dto);
        assertEquals("VERANO15", dto.getCodigo());
    }

    // Test: actualizar cupón
    @Test
    void actualizar_shouldReturnUpdatedMessage() {
        Cupon cupon = new Cupon();
        cupon.setCodigo("ACTUALIZADO");

        when(cuponRepo.findById(1L)).thenReturn(Optional.of(new Cupon()));
        when(cuponRepo.save(any(Cupon.class))).thenReturn(cupon);

        String result = cuponService.actualizar(1L, cupon);
        assertEquals("Cupón actualizado correctamente.", result);
    }

    // Test: eliminar cupón
    @Test
    void eliminar_shouldReturnDeletedMessage() {
        when(cuponRepo.existsById(1L)).thenReturn(true);
        doNothing().when(cuponRepo).deleteById(1L);
        String result = cuponService.eliminar(1L);
        assertEquals("Cupón eliminado correctamente.", result);
    }
}
