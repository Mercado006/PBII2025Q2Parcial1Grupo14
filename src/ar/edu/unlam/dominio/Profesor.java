package ar.edu.unlam.dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Profesor {
	
	private Integer dni;
	private String nombre;
	private String apellido;
	private List<Curso> cursosAsignados;
	private List<EntregaTrabajoPractico> entregasDeTrabajosPracticos;
	
	public Profesor(Integer dni, String nombre, String apellido) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.cursosAsignados = new ArrayList<Curso>();
		this.entregasDeTrabajosPracticos = new ArrayList<EntregaTrabajoPractico>();
	}
	
	public List<Curso> getCursosAsignados(){
		return cursosAsignados;
	}

	public boolean anadirCurso(Curso curso) {
		return this.cursosAsignados.add(curso);
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

	public void asignarTrabajoPracticoACurso(TrabajoPractico trabajoPractico, Curso curso) {
		for(Alumno alumno : curso.getAlumnos()) {
			alumno.recibirTrabajoPractico(trabajoPractico);
		}
	}

	public void recibirEntregaTrabajoPractico(EntregaTrabajoPractico entregaTrabajoPracticoUno) {
		this.entregasDeTrabajosPracticos.add(entregaTrabajoPracticoUno);
	}

	public void corregirEntregaTrabajoPractico(EntregaTrabajoPractico entregaTrabajoPractico, Integer nota) {
		for(EntregaTrabajoPractico entregaTP : entregasDeTrabajosPracticos) {
			if(entregaTP.equals(entregaTrabajoPractico) && !entregaTP.getFueCorregido()) {
				entregaTP.setFueCorregido(true);
				entregaTP.setNota(nota);
			}	
		}
	}
	
	public List<EntregaTrabajoPractico> obtenerEntregaDeTrabajosPracticosSinCorregir() {
		List<EntregaTrabajoPractico> listaDeTrabajosPracticonSinCorregir = new ArrayList<EntregaTrabajoPractico>();
		
		for(EntregaTrabajoPractico entregaTrabajoPractico : entregasDeTrabajosPracticos) {
			if(!entregaTrabajoPractico.getFueCorregido()) {
				listaDeTrabajosPracticonSinCorregir.add(entregaTrabajoPractico);
			}
		}
		
		return listaDeTrabajosPracticonSinCorregir;
	}

	public List<EntregaTrabajoPractico> getEntregasDeTrabajosPracticos() {
		return entregasDeTrabajosPracticos;
	}
}
