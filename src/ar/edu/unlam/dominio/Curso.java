package ar.edu.unlam.dominio;



public class Curso {
	
	private Integer idCurso;
	private String nombre;
	private Integer capacidad;

	
	public Curso(Integer idCurso, String nombre, Integer capacidad) {
		super();
		this.idCurso = idCurso;
		this.nombre = nombre;
		this.capacidad = capacidad;
	}

	public Integer getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}
	
	
	
	
	
}
