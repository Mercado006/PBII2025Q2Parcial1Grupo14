package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class InscripcionTest {
	
	@Test
	public void dadoQueExisteUnaInscripcionConUnaListaDeNotasElMetodoCalcularPromedioDevuelveLaDivisionEntreLasNotasYElSizeDeDichaLista() {
		Integer notaUno = 7;
		Integer notaDos = 8;
		
		Inscripcion inscripcion = new Inscripcion();
		
		inscripcion.agregarNota(notaUno);
		inscripcion.agregarNota(notaDos);
		
		Double promedioEsperado = 7.5;
		Double promedioObtenido = inscripcion.calcularPromedio();
	}
	
	@Test
	public void dadoQueExisteUnaInscripcionConUnaListaDeNotasElMetodoAgregarNotaAgregaLaNotaADichaLista() {
		Integer nota = 7;
		
		Inscripcion inscripcion = new Inscripcion();
		
		inscripcion.agregarNota(nota);
		
		Integer tamanoEsperado = 1;
		Integer tamanoObtenido = inscripcion.getNotas().size();
		
		assertEquals(tamanoEsperado, tamanoObtenido);
	}
	
	@Test
	public void AlCrearUnaInscripcionSeGuardaElAlumnoYElCursoAlQuePertenece() {
		Alumno alumno = new Alumno();
		Curso curso = new Curso();
		
		Inscripcion inscripcion = new Inscripcion(alumno, curso);
		
		assertEquals(alumno, inscripcion.getAlumno());
		assertEquals(curso, inscripcion.getCurso());
	}
	
	@Test
	public void noSePermitenInscripcionesDuplicadasParaElMismoAlumnoYCurso() {
		Inscripcion inscripcionUno = new Inscripcion(new Alumno(), new Curso());
		Inscripcion inscripcionDos = new Inscripcion(new Alumno(), new Curso());
		
		Set<Inscripcion> inscripciones = new HashSet<>(); // Acá faltaría sobreescribir el método equals y hashCode en la clase Inscripcion.
		inscripciones.add(inscripcionUno);
		inscripciones.add(inscripcionDos);
		
		assertEquals(1, inscripciones.size());
	}

}
