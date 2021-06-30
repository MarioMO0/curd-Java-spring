package com.example.demo.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modelo.Empleado;

@Repository
public interface IEmpleado extends CrudRepository<Empleado, Integer>{
	
}
