package ar.edu.unlam.dominio;

public class CursoMusica extends Curso implements Evaluable {

	private String instrumentoPrincipal;
	private Double promedioFinalConElQueSeAprueba;

	public CursoMusica(Integer idCurso, String nombre, Integer capacidad, String instrumentoPrincipal, Double promedioFinalConElQueSeAprueba) {
		super(idCurso, nombre, capacidad);
		this.instrumentoPrincipal = instrumentoPrincipal;
		this.promedioFinalConElQueSeAprueba = promedioFinalConElQueSeAprueba;
	}

	public String getInstrumentoPrincipal() {
		return instrumentoPrincipal;
	}

	public void setInstrumentoPrincipal(String instrumentoPrincipal) {
		this.instrumentoPrincipal = instrumentoPrincipal;
	}

	@Override
	public Boolean estaAprobado(Double promedioFinal) {
		return promedioFinal >= promedioFinalConElQueSeAprueba;
	}
}