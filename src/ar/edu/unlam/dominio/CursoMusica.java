package ar.edu.unlam.dominio;

public class CursoMusica extends Curso {

	private String instrumentoPrincipal;

	public CursoMusica(Integer idCurso, String nombre, Integer capacidad, String instrumentoPrincipal) {
		super(idCurso, nombre, capacidad);
		this.instrumentoPrincipal = instrumentoPrincipal;
	}

	public String getInstrumentoPrincipal() {
		return instrumentoPrincipal;
	}

	public void setInstrumentoPrincipal(String instrumentoPrincipal) {
		this.instrumentoPrincipal = instrumentoPrincipal;
	}
}