package com.example.demo.interfazServicio;

import java.util.List;
import java.util.Optional;

import com.example.demo.modelo.Empleado;

public interface IempleadoService {
	public List<Empleado> listar();
	public Optional<Empleado>buscarId(int id);
	public int guardar(Empleado e);
	public void eliminar(int id);
}
