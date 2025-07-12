//francisco Rodriguez
package cl.proyecto.edutech.dto;

import cl.proyecto.edutech.model.Tarjeta;
import java.time.LocalDate;

public class TarjetaDTO {
    private Long tarjetaId;
    private Long usuarioId;
    private Integer formaPagoId;
    private String numero;
    private LocalDate fechaVencimiento;

    public TarjetaDTO() {}

    public TarjetaDTO(Tarjeta t) {
        this.tarjetaId      = t.getTarjetaId();
        this.usuarioId      = t.getUsuario().getUsuarioId();
        this.formaPagoId    = t.getFormaDePago().getId();
        this.numero         = t.getNumero();
        this.fechaVencimiento = t.getFechaVencimiento();
    }

    public Long getTarjetaId() {
        return tarjetaId;
    }

    public void setTarjetaId(Long tarjetaId) {
        this.tarjetaId = tarjetaId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Integer getFormaPagoId() {
        return formaPagoId;
    }

    public void setFormaPagoId(Integer formaPagoId) {
        this.formaPagoId = formaPagoId;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public LocalDate getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    
}
