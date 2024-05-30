package com.example.demo.Entidad;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class FacturaEntity {

    @Id
    private String id;
    private int numFactura;
    private String fechaEmision;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public int getNumFactura() {
        return numFactura;
    }
    public void setNumFactura(int numFactura) {
        this.numFactura = numFactura;
    }
    public String getFechaEmision() {
        return fechaEmision;
    }
    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }
        
}
