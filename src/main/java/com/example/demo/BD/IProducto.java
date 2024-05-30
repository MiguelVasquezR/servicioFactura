package com.example.demo.BD;

import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import com.example.demo.Entidad.ProductoEntity;

public interface IProducto extends CrudRepository<ProductoEntity, Integer> {
    ArrayList<ProductoEntity> findByIdFactura(String idFactura);
}
