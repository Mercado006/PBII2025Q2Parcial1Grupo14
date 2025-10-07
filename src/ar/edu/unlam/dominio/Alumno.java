package ar.edu.unlam.dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Alumno {

	private Integer dni;
	private String nombre;
	private String apellido;
	private List<TrabajoPractico> trabajosPracticos;
	
	public Alumno(Integer dni, String nombre, String apellido) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.trabajosPracticos = new ArrayList<>();
	}
	
	public List<TrabajoPractico> getTrabajosPracticos() {
		return trabajosPracticos;
	}

	public void recibirTrabajoPractico(TrabajoPractico trabajoPractico) {
		trabajosPracticos.add(trabajoPractico);
	}
	
	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public boolean entregarTrabajoPractico(TrabajoPractico trabajoPractico, LocalDate fechaEntrega) {
		return false;
	}
}
