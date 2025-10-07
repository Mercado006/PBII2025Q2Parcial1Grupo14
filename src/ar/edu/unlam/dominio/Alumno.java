package ar.edu.unlam.dominio;

public class Alumno {

	private Integer dni;
	private String nombre;
	private String apellido;
	
	public Alumno(Integer dni, String nombre, String apellido) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
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

	public boolean entregarTrabajoPractico(TrabajoPractico trabajoPractico) {
		return false;
	}
}
