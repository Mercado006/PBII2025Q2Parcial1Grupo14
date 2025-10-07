package ar.edu.unlam.dominio;

public class CursoProgramacion extends Curso {
	
	private String lenguajePrincipal;

	public CursoProgramacion(Integer idCurso, String nombre, Integer capacidad, String lenguajePrincipal) {
		super(idCurso, nombre, capacidad);
		this.lenguajePrincipal = lenguajePrincipal;
	}

	public String getLenguajePrincipal() {
		return lenguajePrincipal;
	}

	public void setLenguajePrincipal(String lenguajePrincipal) {
		this.lenguajePrincipal = lenguajePrincipal;
	}
}
