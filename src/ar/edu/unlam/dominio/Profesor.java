package ar.edu.unlam.dominio;

import java.util.ArrayList;
import java.util.List;

public class Profesor {
	
	private Integer dni;
	private String nombre;
	private String apellido;
	private List<Curso> cursosAsignados;
	
	public Profesor(Integer dni, String nombre, String apellido) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.cursosAsignados = new ArrayList<Curso>();
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
		// TODO Auto-generated method stub
		
	}

	public boolean agregarCurso(Curso curso) {
		// TODO Auto-generated method stub
		return false;
	}

	public void recibirEntregaTrabajoPractico(EntregaTrabajoPractico entregaTrabajoPracticoUno) {
		// TODO Auto-generated method stub
		
	}

	public void corregirEntregaTrabajoPractico(EntregaTrabajoPractico entregaTrabajoPracticoUno) {
		// TODO Auto-generated method stub
		
	}
	
	public void corregirEntregaTrabajoPractico(EntregaTrabajoPractico entregaTrabajoPractico, Integer nota) {
		// TODO Auto-generated method stub
		
	}

	public List<TrabajoPractico> obtenerEntregaDeTrabajosPracticosSinCorregir() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
