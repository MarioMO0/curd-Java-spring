package com.example.demo.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaces.IEmpleado;
import com.example.demo.interfazServicio.IempleadoService;
import com.example.demo.modelo.Empleado;
@Service
public class EmpleadoService implements IempleadoService{
	@Autowired
	private IEmpleado data;
	
	@Override
	public List<Empleado> listar() {
		return (List<Empleado>)data.findAll();
	}

	@Override
	public Optional<Empleado> buscarId(int id) {
		return data.findById(id);
	}

	@Override
	public int guardar(Empleado e) {
		int res=0;
		Empleado empleado=data.save(e);
		if(!empleado.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void eliminar(int id) {
		data.deleteById(id);
	}

}
