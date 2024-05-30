package com.example.demo.BD;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.Entidad.FacturaEntity;

public interface IFactura extends CrudRepository<FacturaEntity, Integer> {
    FacturaEntity findByNumFactura(int numFactura);
}
