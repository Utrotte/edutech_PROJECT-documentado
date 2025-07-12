package cl.proyecto.edutech.model;

//Roberto Gonzalezz

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;

@Entity
public class Cupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cuponId;
    private String codigo;
    private Double descuento;
    private LocalDate validoHasta;

    public Cupon() {
    }

    public Cupon(String codigo, Double descuento, LocalDate validoHasta) {
        this.codigo = codigo;
        this.descuento = descuento;
        this.validoHasta = validoHasta;
    }

    public Long getCuponId() {
        return cuponId;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public LocalDate getValidoHasta() {
        return validoHasta;
    }

    public void setValidoHasta(LocalDate validoHasta) {
        this.validoHasta = validoHasta;
    }
}
