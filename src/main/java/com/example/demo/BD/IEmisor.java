package com.example.demo.BD;
import org.springframework.data.repository.CrudRepository;

import com.example.demo.Entidad.EmisorEntity;

public interface IEmisor extends CrudRepository<EmisorEntity, Integer> {

}
