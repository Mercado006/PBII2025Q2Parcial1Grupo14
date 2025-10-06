package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

public class AlumnoTest {
	
	@Test	
	public void dadoQueExisteUnAlumnoConElMetodoEntregarTrabajoPracticoDevuelveFalseSiDichoTrabajoNoSeEncuentraEnSuListaDeTrabajosPracticos() {
	// Testea el metodo de Alumno entregarTrabajoPractico para chequear que devuelva falso si no tiene dicho T.P. asignado.
		Profesor profesor = new Profesor();
		Alumno alumnoUno = new Alumno();
		Alumno alumnoDos = new Alumno();
		Curso curso = new Curso();
		
		Sistema sistema = new Sistema();
		sistema.agregarCurso(curso);
		sistema.anadirProfesor(profesor, curso);
		sistema.inscribirAlumno(alumnoDos, curso);
		
		LocalDate fechaEntrega = LocalDate.of(2025, 10, 20);
		TrabajoPractico trabajoPractico = new TrabajoPractico(fechaEntrega, curso);
		
		LocalDate fechaQueSeEntrego = LocalDate.of(2025, 10, 10);
		assertFalse(alumnoUno.entregarTrabajoPractico(trabajoPractico, fechaQueSeEntrego));
	}
	
	@Test	
	public void dadoQueExisteUnAlumnoConElMetodoEntregarTrabajoPracticoSiEsExitosoDichoTrabajoEsRemovidoDeSuListaDeTrabajosPracticos() {
	// Testea el metodo de Alumno entregarTrabajoPractico para chequear que si todo sale bien se remueve dicho T.P. de su lista de trabajosPracticos.
		Profesor profesor = new Profesor();
		Alumno alumno = new Alumno();
		Curso curso = new Curso();
		
		Sistema sistema = new Sistema();
		sistema.agregarCurso(curso);
		sistema.anadirProfesor(profesor, curso);
		sistema.inscribirAlumno(alumno, curso);
		
		LocalDate fechaEntrega = LocalDate.of(2025, 10, 20);
		TrabajoPractico trabajoPractico = new TrabajoPractico(fechaEntrega, curso);
		
		profesor.asignarTrabajoPracticoACurso(trabajoPractico, curso);
		
		LocalDate fechaQueSeEntrego = LocalDate.of(2025, 10, 10);
		alumno.entregarTrabajoPractico(trabajoPractico);
		
		assertFalse(alumno.getTrabajosPracticos().contains(trabajoPractico));
	}
	
	@Test	
	public void dadoQueExisteUnAlumnoConElMetodoEntregarTrabajoPracticoSeGeneraUnaEntregaTrabajoPracticoYSeAgregaALaListaDeEntregasTrabajosPracticosDelProfesorDelCurso() {
		Profesor profesor = new Profesor();
		Alumno alumno = new Alumno();
		Curso curso = new Curso();
		
		Sistema sistema = new Sistema();
		sistema.agregarCurso(curso);
		sistema.anadirProfesor(profesor, curso);
		sistema.inscribirAlumno(alumno, curso);
		
		LocalDate fechaEntrega = LocalDate.of(2025, 10, 20);
		TrabajoPractico trabajoPractico = new TrabajoPractico(fechaEntrega, curso);
		
		profesor.asignarTrabajoPracticoACurso(trabajoPractico, curso);
		
		LocalDate fechaQueSeEntrego = LocalDate.of(2025, 10, 10);
		alumno.entregarTrabajoPractico(trabajoPractico);
		
		Integer tamanoEsperado = 1;
		Integer tamanoObtenido = profesor.obtenerEntregasTrabajosPracticos().size();
		
		assertEquals(tamanoEsperado, tamanoObtenido);
	}
	
	@Test	
	public void dadoQueExisteUnAlumnoConElMetodoEntregarTrabajoPracticoSeGeneraUnaEntregaTrabajoPracticoQueSeAgregaALaListaDeEntregasTrabajosPracticosDelProfesorDelCursoYContieneAlAlumnoQueRealizoLaEntrega() {
		Profesor profesor = new Profesor();
		Alumno alumno = new Alumno();
		Curso curso = new Curso();
		
		Sistema sistema = new Sistema();
		sistema.agregarCurso(curso);
		sistema.anadirProfesor(profesor, curso);
		sistema.inscribirAlumno(alumno, curso);
		
		LocalDate fechaEntrega = LocalDate.of(2025, 10, 20);
		TrabajoPractico trabajoPractico = new TrabajoPractico(fechaEntrega, curso);
		
		profesor.asignarTrabajoPracticoACurso(trabajoPractico, curso);
		
		LocalDate fechaQueSeEntrego = LocalDate.of(2025, 10, 10);
		alumno.entregarTrabajoPractico(trabajoPractico);
		
		List<EntregaTrabajoPractico> entregasTrabajosPracticos = new ArrayList<>(profesor.obtenerEntregasTrabajosPracticos());
		
		assertTrue(entregasTrabajosPracticos.get(0).getAlumno().equals(alumno));
	}
	
	@Test	
	public void dadoQueExisteUnAlumnoConElMetodoEntregarTrabajoPracticoSeGeneraUnaEntregaTrabajoPracticoQueSeAgregaALaListaDeEntregasTrabajosPracticosDelProfesorDelCursoYContieneLaFechaDeEntrega() {
		Profesor profesor = new Profesor();
		Alumno alumno = new Alumno();
		Curso curso = new Curso();
		
		Sistema sistema = new Sistema();
		sistema.agregarCurso(curso);
		sistema.anadirProfesor(profesor, curso);
		sistema.inscribirAlumno(alumno, curso);
		
		LocalDate fechaEntrega = LocalDate.of(2025, 10, 20);
		TrabajoPractico trabajoPractico = new TrabajoPractico(fechaEntrega, curso);
		
		profesor.asignarTrabajoPracticoACurso(trabajoPractico, curso);
		
		LocalDate fechaQueSeEntrego = LocalDate.of(2025, 10, 10);
		alumno.entregarTrabajoPractico(trabajoPractico);
		
		List<EntregaTrabajoPractico> entregasTrabajosPracticos = new ArrayList<>(profesor.obtenerEntregasTrabajosPracticos());
		
		assertTrue(entregasTrabajosPracticos.get(0).getFechaDeEntrega().equals(fechaQueSeEntrego));
	}
}
