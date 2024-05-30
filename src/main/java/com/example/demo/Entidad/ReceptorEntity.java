package com.example.demo.Entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ReceptorEntity {
    @Id
    private String id;
    private String nombre;
    private String rfc;
    private String regimenFiscal;
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
    public String getRfc() {
        return rfc;
    }
    public void setRfc(String rfc) {
        this.rfc = rfc;
    }
    public String getRegimenFiscal() {
        return regimenFiscal;
    }
    public void setRegimenFiscal(String regimenFiscal) {
        this.regimenFiscal = regimenFiscal;
    }
    public String getIdFactura() {
        return idFactura;
    }
    public void setIdFactura(String idFactura) {
        this.idFactura = idFactura;
    }
    
    
    
}
