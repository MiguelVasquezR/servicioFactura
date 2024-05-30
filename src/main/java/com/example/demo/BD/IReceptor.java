package com.example.demo.BD;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Entidad.ReceptorEntity;

public interface IReceptor extends CrudRepository<ReceptorEntity, Integer> {

}
