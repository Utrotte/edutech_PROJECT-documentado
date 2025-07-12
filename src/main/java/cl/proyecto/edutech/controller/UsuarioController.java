package cl.proyecto.edutech.controller;//Roberto Gonzalez

import cl.proyecto.edutech.dto.UsuarioDTO;
import cl.proyecto.edutech.model.Usuario;
import cl.proyecto.edutech.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public String crear(@RequestBody Usuario usuario) {
        return usuarioService.crear(usuario);
    }

    @GetMapping
    public List<UsuarioDTO> listar() {
        return usuarioService.listar()
                             .stream()
                             .map(UsuarioDTO::new)
                             .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtener(@PathVariable Long id) { // Tipo de retorno cambiado
        UsuarioDTO dto = usuarioService.obtenerPorId(id);

        if (dto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado con ID: " + id);
        } else {
            return ResponseEntity.ok(dto);
        }
    }

    @PutMapping("/{id}/desactivar")
    public ResponseEntity<Object> desactivar(@PathVariable Long id) {
        String serviceMessage = usuarioService.desactivar(id);
        
        Map<String, Object> responseBody = new LinkedHashMap<>();
        responseBody.put("timestamp", LocalDateTime.now());

        if (serviceMessage.equals("Usuario no encontrado.")) {
            responseBody.put("status", HttpStatus.NOT_FOUND.value());
            responseBody.put("error", "Not Found");
            responseBody.put("message", serviceMessage);
            return new ResponseEntity<>(responseBody, HttpStatus.NOT_FOUND);
        } else {
            responseBody.put("status", HttpStatus.OK.value());
            responseBody.put("message", serviceMessage);
            return new ResponseEntity<>(responseBody, HttpStatus.OK);
        }
    }
    @PutMapping("/{id}/activar")
    public ResponseEntity<Object> activar(@PathVariable Long id) {
        String serviceMessage = usuarioService.activar(id);
        
        Map<String, Object> responseBody = new LinkedHashMap<>();
        responseBody.put("timestamp", LocalDateTime.now());

        if (serviceMessage.equals("Usuario no encontrado.")) {
            responseBody.put("status", HttpStatus.NOT_FOUND.value());
            responseBody.put("error", "Not Found");
            responseBody.put("message", serviceMessage);
            return new ResponseEntity<>(responseBody, HttpStatus.NOT_FOUND);
        } else {
            responseBody.put("status", HttpStatus.OK.value());
            responseBody.put("message", serviceMessage);
            return new ResponseEntity<>(responseBody, HttpStatus.OK);
        }
    }
}
