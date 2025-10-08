package ar.edu.unlam.dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Alumno {

	private Integer dni;
	private String nombre;
	private String apellido;
	private List<TrabajoPractico> trabajosPracticos;
	private Set<Inscripcion> inscripciones;
	
	public Alumno(Integer dni, String nombre, String apellido) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.trabajosPracticos = new ArrayList<>();
		this.inscripciones = new HashSet<>();
	}
	
	public Boolean anadirInscripcion(Inscripcion inscripcion) {
		return inscripciones.add(inscripcion);
	}
	
	public Inscripcion obtenerInscripcionPorCurso(Curso curso) {
		for(Inscripcion inscripcion : inscripciones) {
			if(inscripcion.getCurso().equals(curso)) {
				return inscripcion;
			}
		}
		return null;
	}

	public Set<Inscripcion> getInscripciones() {
		return inscripciones;
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
		if(trabajosPracticos.contains(trabajoPractico) && trabajoPractico.puedeSerEntregado(fechaEntrega)) {
			EntregaTrabajoPractico entregaTrabajoPractico = new EntregaTrabajoPractico(this, fechaEntrega, trabajoPractico.getCursoAlQuePertenece());
			trabajoPractico.getCursoAlQuePertenece().getProfesor().recibirEntregaTrabajoPractico(entregaTrabajoPractico);
			return true;
		};
		return false;
	}
}
