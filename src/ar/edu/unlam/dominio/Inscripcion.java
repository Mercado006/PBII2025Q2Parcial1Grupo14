package ar.edu.unlam.dominio;

import java.util.ArrayList;
import java.util.List;

public class Inscripcion {

	private Integer idCurso;
	private Integer dniAlumno;
	private List<Integer> notas;

	public Inscripcion(Integer idCurso, Integer dniAlumno) {
		super();
		this.idCurso = idCurso;
		this.dniAlumno = dniAlumno;
		this.notas = new ArrayList<Integer>();
	}

	public List<Integer> getNotas() {
		return notas;
	}

	public Integer getIdCurso() {
		return idCurso;
	}

	public void setIdCurso(Integer idCurso) {
		this.idCurso = idCurso;
	}

	public Integer getDniAlumno() {
		return dniAlumno;
	}

	public void setDniAlumno(Integer dniAlumno) {
		this.dniAlumno = dniAlumno;
	}

	public void agregarNota(Integer notaUno) {
		this.notas.add(notaUno);
	}

	public Double calcularPromedio() {

		Double acumulador = 0.0;
		if (this.notas != null && this.notas.isEmpty() != true) {
			for (Integer nota : this.notas) {
				acumulador += nota;
			}

			return acumulador / this.notas.size();
		}

		return 0.0;
	}
}