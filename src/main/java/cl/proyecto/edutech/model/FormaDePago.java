package cl.proyecto.edutech.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


// victor espindola
@Entity
public class FormaDePago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )  
    private int id;
    private String nombre;
    private String descripcion;

    public FormaDePago(){
        this.id = 0 ;
        this.nombre = "";
        this.descripcion = "";
 
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}

