package ar.edu.unlam.dominio;

public class CursoMusica extends Curso {

	private String instrumentoPrincipal;
	private Boolean requiereLecturaMusical;

	public CursoMusica(Integer idCurso, String nombre, Integer capacidad, String instrumentoPrincipal, Boolean requiereLecturaMusical) {
		super(idCurso, nombre, capacidad);
		this.instrumentoPrincipal = instrumentoPrincipal;
		this.requiereLecturaMusical = requiereLecturaMusical;
	}

	public String getInstrumentoPrincipal() {
		return instrumentoPrincipal;
	}

	public void setInstrumentoPrincipal(String instrumentoPrincipal) {
		this.instrumentoPrincipal = instrumentoPrincipal;
	}

	public Boolean getRequiereLecturaMusical() {
		return requiereLecturaMusical;
	}

	public void setRequiereLecturaMusical(Boolean requiereLecturaMusical) {
		this.requiereLecturaMusical = requiereLecturaMusical;
	}
}