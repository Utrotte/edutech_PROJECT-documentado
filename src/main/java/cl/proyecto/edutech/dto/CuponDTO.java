//Roberto Gonzalez

package cl.proyecto.edutech.dto;

import cl.proyecto.edutech.model.Cupon;
import java.time.LocalDate;

public class CuponDTO {
    private Long cuponId;
    private String codigo;
    private Double descuento;
    private LocalDate validoHasta;

    public CuponDTO() {}

    public CuponDTO(Cupon cupon) {
        this.cuponId     = cupon.getCuponId();
        this.codigo      = cupon.getCodigo();
        this.descuento   = cupon.getDescuento();
        this.validoHasta = cupon.getValidoHasta();
    }

    
    public Long getCuponId() { return cuponId; }
    public void setCuponId(Long cuponId) { this.cuponId = cuponId; }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public Double getDescuento() { return descuento; }
    public void setDescuento(Double descuento) { this.descuento = descuento; }

    public LocalDate getValidoHasta() { return validoHasta; }
    public void setValidoHasta(LocalDate validoHasta) { this.validoHasta = validoHasta; }
}
