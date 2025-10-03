package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

public class AlumnoTest {
	
	@Test	
	public void dadoQueExisteUnAlumnoConElMetodoEntregarTrabajoPracticoDevuelveFalseSiDichoTrabajoNoSeEncuentraEnSuListaDeTrabajosPracticos() {
	// Testea el m�todo de Alumno entregarTrabajoPractico para chequear que devuelva falso si no tiene dicho T.P. asignado.
		Profesor profesor = new Profesor();
		Alumno alumnoUno = new Alumno();
		Alumno alumnoDos = new Alumno();
		
		Curso curso = new Curso();
		// Se inscribe solo el alumnoDos al curso, junto al profesor
		
		LocalDate fechaEntrega = LocalDate.of(2025, 10, 20);
		TrabajoPractico trabajoPractico = new TrabajoPractico(fechaEntrega, curso);
		
		LocalDate fechaQueSeEntrego = LocalDate.of(2025, 10, 10);
		assertFalse(alumnoUno.entregarTrabajoPractico(trabajoPractico, fechaQueSeEntrego));
	}
	
	@Test	
	public void dadoQueExisteUnAlumnoConElMetodoEntregarTrabajoPracticoSiEsExitosoDichoTrabajoEsRemovidoDeSuListaDeTrabajosPracticos() {
	// Testea el m�todo de Alumno entregarTrabajoPractico para chequear que si todo sale bien se remueve dicho T.P. de su lista de trabajosPracticos.
		Profesor profesor = new Profesor();
		Alumno alumno = new Alumno();
		
		Curso curso = new Curso();
		// Ac� se tendr�a que incorporar el alumno y profesor al curso
		
		LocalDate fechaEntrega = LocalDate.of(2025, 10, 20);
		TrabajoPractico trabajoPractico = new TrabajoPractico(fechaEntrega, curso);
		
		profesor.asignarTrabajoPracticoACurso(trabajoPractico, curso);
		
		LocalDate fechaQueSeEntrego = LocalDate.of(2025, 10, 10);
		alumno.entregarTrabajoPractico(trabajoPractico);
		
		assertFalse(alumno.getTrabajosPracticos.contains(trabajoPractico));
	}
	
	@Test	
	public void dadoQueExisteUnAlumnoConElMetodoEntregarTrabajoPracticoSiEsExitosoSeActualizaElAtributoAlumnoDeDichoTrabajo() {
	// Testea el m�todo de Alumno entregarTrabajoPractico para chequear que si todo sale bien se remueve dicho T.P. de su lista de trabajosPracticos.
		Profesor profesor = new Profesor();
		Alumno alumno = new Alumno();
		
		Curso curso = new Curso();
		// Ac� se tendr�a que incorporar el alumno y profesor al curso
		
		LocalDate fechaEntrega = LocalDate.of(2025, 10, 20);
		TrabajoPractico trabajoPractico = new TrabajoPractico(fechaEntrega, curso);
		
		profesor.asignarTrabajoPracticoACurso(trabajoPractico, curso);
		
		LocalDate fechaQueSeEntrego = LocalDate.of(2025, 10, 10);
		alumno.entregarTrabajoPractico(trabajoPractico);
		
		Alumno alumnoEsperado = alumno;
		Alumno alumnoObtenido = trabajoPractico.getAlumno();
		assertEquals(alumnoEsperado, alumnoObtenido);
	}
	
	@Test	
	public void dadoQueExisteUnCursoConElMetodoRecibirTrabajoPracticoDevuelveFalseSiSeIntentaEntregarDichoTrabajoFueraDeLaFechaEstipuladaEnTrabajoPractico() {
	// Testea el m�todo de Curso recibirTrabajoPractico para que no se puedan entregar trabajos fuera de plazo.
		Profesor profesor = new Profesor();
		Alumno alumno = new Alumno();
		
		Curso curso = new Curso();
		// Ac� se tendr�a que incorporar el alumno y profesor al curso
		
		LocalDate fechaEntrega = LocalDate.of(2025, 10, 20);
		TrabajoPractico trabajoPractico = new TrabajoPractico(fechaEntrega, curso);
		
		profesor.asignarTrabajoPracticoACurso(trabajoPractico, curso);
		
		LocalDate fechaQueSeEntrego = LocalDate.of(2025, 10, 21);
		assertFalse(alumno.entregarTrabajoPractico(trabajoPractico));
	}
}
