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
		
		Integer dni = 123;
		String nombre = "nombre";
		String apellido = "apellido";
		Alumno alumno = new Alumno(dni, nombre, apellido);
		
		Integer id = 1;
		String nombreCurso = "Introducción a la programación";
		Integer capacidad = 100;
		String lenguajePrincipal = "Java";
		Curso cursoProgramacion = new CursoProgramacion(id, nombreCurso, capacidad, lenguajePrincipal);
		
		Inscripcion inscripcion = new Inscripcion(cursoProgramacion, alumno);
		
		inscripcion.agregarNota(notaUno);
		inscripcion.agregarNota(notaDos);
		
		Double promedioEsperado = 7.5;
		Double promedioObtenido = inscripcion.calcularPromedio();
	}
	
	@Test
	public void dadoQueExisteUnaInscripcionConUnaListaDeNotasElMetodoAgregarNotaAgregaLaNotaADichaLista() {
		Integer nota = 7;
		
		Integer dni = 123;
		String nombre = "nombre";
		String apellido = "apellido";
		Alumno alumno = new Alumno(dni, nombre, apellido);
		
		Integer id = 1;
		String nombreCurso = "Introducción a la programación";
		Integer capacidad = 100;
		String lenguajePrincipal = "Java";
		Curso cursoProgramacion = new CursoProgramacion(id, nombreCurso, capacidad, lenguajePrincipal);
		
		Inscripcion inscripcion = new Inscripcion(cursoProgramacion, alumno);
		
		inscripcion.agregarNota(nota);
		
		Integer tamanoEsperado = 1;
		Integer tamanoObtenido = inscripcion.getNotas().size();
		
		assertEquals(tamanoEsperado, tamanoObtenido);
	}
	
	@Test
	public void dadoQueExisteUnaInscripcionAlInstanciarlaSeGuardanElAlumnoYElCursoAlQuePertenece() {
		Integer dni = 123;
		String nombre = "nombre";
		String apellido = "apellido";
		Alumno alumno = new Alumno(dni, nombre, apellido);
		
		Integer id = 1;
		String nombreCurso = "Introducción a la programación";
		Integer capacidad = 100;
		String lenguajePrincipal = "Java";
		Curso cursoProgramacion = new CursoProgramacion(id, nombreCurso, capacidad, lenguajePrincipal);
		
		Inscripcion inscripcion = new Inscripcion(cursoProgramacion, alumno);
		
		assertEquals(alumno, inscripcion.getAlumno());
		assertEquals(cursoProgramacion, inscripcion.getCurso());
	}
}
