package ar.edu.unlam.dominio;

public class CursoDisenio extends Curso {

	private String softwarePrincipal;

	public CursoDisenio(Integer idCurso, String nombre, Integer capacidad, String softwarePrincipal) {
		super(idCurso, nombre, capacidad);
		this.softwarePrincipal = softwarePrincipal;
	}

	public String getSoftwarePrincipal() {
		return softwarePrincipal;
	}

	public void setSoftwarePrincipal(String softwarePrincipal) {
		this.softwarePrincipal = softwarePrincipal;
	}
}