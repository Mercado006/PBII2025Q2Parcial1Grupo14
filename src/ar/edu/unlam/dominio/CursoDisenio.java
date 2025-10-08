package ar.edu.unlam.dominio;

public class CursoDisenio extends Curso implements Evaluable {

	private String softwarePrincipal;
	private Double promedioFinalConElQueSeAprueba;

	public CursoDisenio(Integer idCurso, String nombre, Integer capacidad, String softwarePrincipal, Double promedioFinalConElQueSeAprueba) {
		super(idCurso, nombre, capacidad);
		this.softwarePrincipal = softwarePrincipal;
		this.promedioFinalConElQueSeAprueba = promedioFinalConElQueSeAprueba;
	}

	public String getSoftwarePrincipal() {
		return softwarePrincipal;
	}

	public void setSoftwarePrincipal(String softwarePrincipal) {
		this.softwarePrincipal = softwarePrincipal;
	}

	@Override
	public Boolean estaAprobado(Double promedioFinal) {
		return promedioFinal >= promedioFinalConElQueSeAprueba;
	}
}