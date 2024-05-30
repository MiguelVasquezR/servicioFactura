package com.example.demo.Entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ProductoEntity {
    @Id
    private String id;
    private String nombre;
    private String precioUnitario;
    private String cantidad;
    private String idFactura;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getCantidad() {
        return cantidad;
    }
    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
    public String getIdFactura() {
        return idFactura;
    }
    public void setIdFactura(String idFactura) {
        this.idFactura = idFactura;
    }
    public String getPrecioUnitario() {
        return precioUnitario;
    }
    public void setPrecioUnitario(String precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
}
