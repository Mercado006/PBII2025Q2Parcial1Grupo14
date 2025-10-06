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



	public List<Integer> getNotas() {
		return notas;
	}
	

	public void agregarNota(Integer notaUno) {
		// TODO Auto-generated method stub
		this.notas.add(notaUno);
	}

	public Double calcularPromedio() {
		// TODO Auto-generated method stub
		return null;
	}

}
