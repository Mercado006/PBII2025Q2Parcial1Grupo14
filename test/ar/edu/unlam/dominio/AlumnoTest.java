package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class AlumnoTest {
	
	@Test	
	public void dadoQueExisteUnAlumnoConElMetodoEntregarTrabajoPracticoDevuelveFalseSiDichoTrabajoNoSeEncuentraEnSuListaDeTrabajosPracticos() {
	// Testea el metodo de Alumno entregarTrabajoPractico para chequear que devuelva falso si no tiene dicho T.P. asignado.
		String nombre = "nombre";
		String apellido = "apellido";
		Integer dni = 123;
		
		Profesor profesor = new Profesor(dni, nombre, apellido);
		Alumno alumnoUno = new Alumno(dni, nombre, apellido);
		Alumno alumnoDos = new Alumno(dni, nombre, apellido);
		
		Integer id = 1;
		String nombreCurso = "Introduccion a la programacion";
		Integer capacidad = 100;
		String lenguajePrincipal = "Java";
		Curso cursoProgramacion = new CursoProgramacion(id, nombreCurso, capacidad, lenguajePrincipal);
		
		Sistema sistema = new Sistema();
		sistema.agregarCurso(cursoProgramacion);
		sistema.anadirAlumno(alumnoDos);
		sistema.anadirAlumno(alumnoUno);
		sistema.anadirProfesor(profesor);
		sistema.anadirProfesorACurso(profesor, cursoProgramacion);
		sistema.anadirAlumnoACurso(alumnoDos, cursoProgramacion);
		
		LocalDate fechaEntrega = LocalDate.of(2025, 10, 20);
		TrabajoPractico trabajoPractico = new TrabajoPractico(fechaEntrega, cursoProgramacion);
		
		LocalDate fechaQueSeEntrego = LocalDate.of(2025, 10, 10);
		assertFalse(alumnoUno.entregarTrabajoPractico(trabajoPractico, fechaQueSeEntrego));
	}
	
	@Test	
	public void dadoQueExisteUnAlumnoConElMetodoEntregarTrabajoPracticoSiEsExitosoDichoTrabajoEsRemovidoDeSuListaDeTrabajosPracticos() {
	// Testea el metodo de Alumno entregarTrabajoPractico para chequear que si todo sale bien se remueve dicho T.P. de su lista de trabajosPracticos.
		String nombre = "nombre";
		String apellido = "apellido";
		Integer dni = 123;
		
		Profesor profesor = new Profesor(dni, nombre, apellido);
		Alumno alumno = new Alumno(dni, nombre, apellido);
		
		Integer id = 1;
		String nombreCurso = "Introducci�n a la programaci�n";
		Integer capacidad = 100;
		String lenguajePrincipal = "Java";
		Curso cursoProgramacion = new CursoProgramacion(id, nombreCurso, capacidad, lenguajePrincipal);
		
		Sistema sistema = new Sistema();
		sistema.agregarCurso(cursoProgramacion);
		sistema.anadirAlumno(alumno);
		sistema.anadirProfesor(profesor);
		sistema.anadirProfesorACurso(profesor, cursoProgramacion);
		sistema.anadirAlumnoACurso(alumno, cursoProgramacion);
		
		LocalDate fechaEntrega = LocalDate.of(2025, 10, 20);
		TrabajoPractico trabajoPractico = new TrabajoPractico(fechaEntrega, cursoProgramacion);
		
		profesor.asignarTrabajoPracticoACurso(trabajoPractico, cursoProgramacion);
		
		LocalDate fechaQueSeEntrego = LocalDate.of(2025, 10, 10);
		alumno.entregarTrabajoPractico(trabajoPractico, fechaQueSeEntrego);
		
		assertFalse(alumno.getTrabajosPracticos().contains(trabajoPractico));
	}
	
	@Test	
	public void dadoQueExisteUnAlumnoConElMetodoEntregarTrabajoPracticoSeGeneraUnaEntregaTrabajoPracticoYSeAgregaALaListaDeEntregasTrabajosPracticosDelProfesorDelCurso() {
		String nombre = "nombre";
		String apellido = "apellido";
		Integer dni = 123;
		
		Profesor profesor = new Profesor(dni, nombre, apellido);
		Alumno alumno = new Alumno(dni, nombre, apellido);
		
		Integer id = 1;
		String nombreCurso = "Introducci�n a la programaci�n";
		Integer capacidad = 100;
		String lenguajePrincipal = "Java";
		Curso cursoProgramacion = new CursoProgramacion(id, nombreCurso, capacidad, lenguajePrincipal);
		
		Sistema sistema = new Sistema();
		sistema.agregarCurso(cursoProgramacion);
		sistema.anadirAlumno(alumno);
		sistema.anadirProfesor(profesor);
		sistema.anadirProfesorACurso(profesor, cursoProgramacion);
		sistema.anadirAlumnoACurso(alumno, cursoProgramacion);
		
		LocalDate fechaEntrega = LocalDate.of(2025, 10, 20);
		TrabajoPractico trabajoPractico = new TrabajoPractico(fechaEntrega, cursoProgramacion);
		
		profesor.asignarTrabajoPracticoACurso(trabajoPractico, cursoProgramacion);
		
		LocalDate fechaQueSeEntrego = LocalDate.of(2025, 10, 10);
		alumno.entregarTrabajoPractico(trabajoPractico, fechaQueSeEntrego);
		
		Integer tamanoEsperado = 1;
		Integer tamanoObtenido = profesor.getEntregasDeTrabajosPracticos().size();
		
		assertEquals(tamanoEsperado, tamanoObtenido);
	}
	
	@Test	
	public void dadoQueExisteUnAlumnoConElMetodoEntregarTrabajoPracticoSeGeneraUnaEntregaTrabajoPracticoQueSeAgregaALaListaDeEntregasTrabajosPracticosDelProfesorDelCursoYContieneAlAlumnoQueRealizoLaEntrega() {
		String nombre = "nombre";
		String apellido = "apellido";
		Integer dni = 123;
		
		Profesor profesor = new Profesor(dni, nombre, apellido);
		Alumno alumno = new Alumno(dni, nombre, apellido);
		
		Integer id = 1;
		String nombreCurso = "Introduccion a la programacion";
		Integer capacidad = 100;
		String lenguajePrincipal = "Java";
		Curso cursoProgramacion = new CursoProgramacion(id, nombreCurso, capacidad, lenguajePrincipal);
		
		Sistema sistema = new Sistema();
		sistema.agregarCurso(cursoProgramacion);
		sistema.anadirAlumno(alumno);
		sistema.anadirProfesor(profesor);
		sistema.anadirProfesorACurso(profesor, cursoProgramacion);
		sistema.anadirAlumnoACurso(alumno, cursoProgramacion);
		
		LocalDate fechaEntrega = LocalDate.of(2025, 10, 20);
		TrabajoPractico trabajoPractico = new TrabajoPractico(fechaEntrega, cursoProgramacion);
		
		profesor.asignarTrabajoPracticoACurso(trabajoPractico, cursoProgramacion);
		
		LocalDate fechaQueSeEntrego = LocalDate.of(2025, 10, 10);
		alumno.entregarTrabajoPractico(trabajoPractico, fechaQueSeEntrego);
		
		List<EntregaTrabajoPractico> entregasTrabajosPracticos = new ArrayList<>(profesor.getEntregasDeTrabajosPracticos());
		
		assertTrue(entregasTrabajosPracticos.get(0).getAlumno().equals(alumno));
	}
	
	@Test	
	public void dadoQueExisteUnAlumnoConElMetodoEntregarTrabajoPracticoSeGeneraUnaEntregaTrabajoPracticoQueSeAgregaALaListaDeEntregasTrabajosPracticosDelProfesorDelCursoYContieneLaFechaDeEntrega() {
		String nombre = "nombre";
		String apellido = "apellido";
		Integer dni = 123;
		
		Profesor profesor = new Profesor(dni, nombre, apellido);
		Alumno alumno = new Alumno(dni, nombre, apellido);
		
		Integer id = 1;
		String nombreCurso = "Introducci�n a la programaci�n";
		Integer capacidad = 100;
		String lenguajePrincipal = "Java";
		Curso cursoProgramacion = new CursoProgramacion(id, nombreCurso, capacidad, lenguajePrincipal);
		
		Sistema sistema = new Sistema();
		sistema.agregarCurso(cursoProgramacion);
		sistema.anadirAlumno(alumno);
		sistema.anadirProfesor(profesor);
		sistema.anadirProfesorACurso(profesor, cursoProgramacion);
		sistema.anadirAlumnoACurso(alumno, cursoProgramacion);
		
		LocalDate fechaEntrega = LocalDate.of(2025, 10, 20);
		TrabajoPractico trabajoPractico = new TrabajoPractico(fechaEntrega, cursoProgramacion);
		
		profesor.asignarTrabajoPracticoACurso(trabajoPractico, cursoProgramacion);
		
		LocalDate fechaQueSeEntrego = LocalDate.of(2025, 10, 10);
		alumno.entregarTrabajoPractico(trabajoPractico, fechaQueSeEntrego);
		
		List<EntregaTrabajoPractico> entregasTrabajosPracticos = new ArrayList<>(profesor.getEntregasDeTrabajosPracticos());
		
		assertTrue(entregasTrabajosPracticos.get(0).getFechaLimite().equals(fechaQueSeEntrego));
	}
	
	@Test	
	public void dadoQueExisteUnAlumnoConElMetodoEntregarTrabajoPracticoDevuelveFalseSiSeIntentaEntregarDichoTrabajoFueraDeLaFechaEstipuladaEnTrabajoPractico() {
		 Integer dni = 123;
		 String nombre = "nombre";
		 String apellido = "apellido";
		 Alumno alumno = new Alumno(dni, nombre, apellido);
		
		 Profesor profesor = new Profesor(dni, nombre, apellido);
		
		Integer id = 1;
		String nombreCurso = "Introduccion a la programaci�n";
		Integer capacidad = 100;
		String lenguajePrincipal = "Java";
		Curso cursoProgramacion = new CursoProgramacion(id, nombreCurso, capacidad, lenguajePrincipal);
		
		Sistema sistema = new Sistema();
		sistema.agregarCurso(cursoProgramacion);
		sistema.anadirAlumno(alumno);
		sistema.anadirProfesor(profesor);
		sistema.anadirProfesorACurso(profesor, cursoProgramacion);
		sistema.anadirAlumnoACurso(alumno, cursoProgramacion);
		
		LocalDate fechaEntrega = LocalDate.of(2025, 10, 20);
		TrabajoPractico trabajoPractico = new TrabajoPractico(fechaEntrega, cursoProgramacion);
		
		profesor.asignarTrabajoPracticoACurso(trabajoPractico, cursoProgramacion);
		
		LocalDate fechaQueSeEntrego = LocalDate.of(2025, 10, 21);
		assertFalse(alumno.entregarTrabajoPractico(trabajoPractico, fechaQueSeEntrego));
	}
}
