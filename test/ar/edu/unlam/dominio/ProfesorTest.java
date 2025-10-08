package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ProfesorTest {
	
	@Test
	public void dadoQueExisteUnProfesorConElMetodoObtenerEntregasDeTrabajosPracticosSinCorregirDevuelveUnaListaDeEntregaTrabajoPracticoCuyoAtributoCorregidoSeaFalse() {
		Profesor profesor = new Profesor(21330190, "Juancito", "Suarez");
		Alumno alumno = new Alumno(24330190, "Pepito", "Suarez");
		Curso curso = new CursoProgramacion(1, "PB2", 20, "Java");
		
		Sistema sistema = new Sistema();
		sistema.agregarCurso(curso);
		sistema.anadirProfesor(profesor);
		sistema.anadirAlumno(alumno);
		sistema.anadirProfesorACurso(profesor, curso);
		sistema.anadirAlumnoACurso(alumno, curso);

		LocalDate fechaEntrega = LocalDate.of(2025, 10, 20);
		EntregaTrabajoPractico entregaTrabajoPracticoUno = new EntregaTrabajoPractico(alumno, fechaEntrega, curso);
		EntregaTrabajoPractico entregaTrabajoPracticoDos = new EntregaTrabajoPractico(alumno, fechaEntrega, curso);
		EntregaTrabajoPractico entregaTrabajoPracticoTres = new EntregaTrabajoPractico(alumno, fechaEntrega, curso);

		profesor.recibirEntregaTrabajoPractico(entregaTrabajoPracticoUno);
		profesor.recibirEntregaTrabajoPractico(entregaTrabajoPracticoDos);
		profesor.recibirEntregaTrabajoPractico(entregaTrabajoPracticoTres);

		Integer nota = 7;
		profesor.corregirEntregaTrabajoPractico(entregaTrabajoPracticoUno, nota);
		
		List<EntregaTrabajoPractico> entregasDetrabajosPracticosSinCorregirObtenidos = profesor.obtenerEntregaDeTrabajosPracticosSinCorregir();
		
		assertTrue(entregasDetrabajosPracticosSinCorregirObtenidos.contains(entregaTrabajoPracticoDos));
		assertTrue(entregasDetrabajosPracticosSinCorregirObtenidos.contains(entregaTrabajoPracticoTres));
		
		Integer tamanioEsperado = 2;
		Integer tamanioObtenido = entregasDetrabajosPracticosSinCorregirObtenidos.size();
		
		assertEquals(tamanioEsperado, tamanioObtenido);
	}
	
	 @Test public void dadoQueExisteUnProfesorConElMetodoCorregirEntregaTrabajoPracticoSeActualizaElEstadoCorregidoDeEntregaTrabajoPracticoATrue() { 
		 Profesor profesor = new Profesor(21330190, "Juancito", "Suarez"); 
		 Alumno alumno = new Alumno(24330190, "Pepito", "Suarez"); 
		 
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
	  
		 LocalDate fechaLimite = LocalDate.of(2025, 10, 20); 
		 TrabajoPractico trabajoPractico = new TrabajoPractico(fechaLimite, cursoProgramacion);
		  
		 profesor.asignarTrabajoPracticoACurso(trabajoPractico, cursoProgramacion);
	  
		 LocalDate fechaEntrega = LocalDate.of(2025, 10, 15);
		 alumno.entregarTrabajoPractico(trabajoPractico, fechaEntrega);
			 
		 Integer nota = 7;
		 EntregaTrabajoPractico entregaTrabajoPractico = profesor.getEntregasDeTrabajosPracticos().get(0);
		 
		 profesor.corregirEntregaTrabajoPractico(entregaTrabajoPractico, nota); 
	  
		 Boolean estadoCorregidoEsperado = true; 
		 Boolean estadoCorregidoObtenido = entregaTrabajoPractico.getFueCorregido();
	  
		 assertEquals(estadoCorregidoEsperado, estadoCorregidoObtenido); 
	 }
	  
	  @Test public void dadoQueExisteUnProfesorConElMetodoRecibirEntregaTrabajoPracticoDichaEntregaTrabajoPracticoSeAgregaASuListaDeEntregasDeTrabajosPracticos() { 
		 Profesor profesor = new Profesor(21330190, "Juancito", "Suarez"); 
		 Alumno alumno = new Alumno(24330190, "Pepito", "Suarez"); 
	  
		 Integer id = 1;
		 String nombreCurso = "Introduccion a la programacion";
		 Integer capacidad = 100;
		 String lenguajePrincipal = "Java";
		 Curso cursoProgramacion = new CursoProgramacion(id, nombreCurso, capacidad, lenguajePrincipal);
	  
		 Sistema sistema = new Sistema(); 
		 sistema.agregarCurso(cursoProgramacion);
		 sistema.anadirProfesor(profesor);
		 sistema.anadirAlumno(alumno);
		 sistema.anadirProfesorACurso(profesor, cursoProgramacion); 
		 sistema.anadirAlumnoACurso(alumno, cursoProgramacion);
	  
		 LocalDate fechaLimite = LocalDate.of(2025, 10, 20); 
		 TrabajoPractico trabajoPractico = new TrabajoPractico(fechaLimite, cursoProgramacion);
		  
		 profesor.asignarTrabajoPracticoACurso(trabajoPractico, cursoProgramacion);
	  
		 LocalDate fechaEntrega = LocalDate.of(2025, 10, 15);
		 alumno.entregarTrabajoPractico(trabajoPractico, fechaEntrega);
		 
		 EntregaTrabajoPractico entregaTrabajoPractico = profesor.getEntregasDeTrabajosPracticos().get(0);
	  
		 assertTrue(profesor.getEntregasDeTrabajosPracticos().contains(entregaTrabajoPractico)); 
	}
	 
	
	  @Test public void dadoQueExisteUnProfesorConElMetodoCorregirEntregaTrabajoPracticoSeActualizaLaNotaDeLaEntregaTrabajoPractico() { 
		  Profesor profesor = new Profesor(21330190, "Juancito", "Suarez"); 
		  
		  Alumno alumno = new Alumno(24330190, "Pepito", "Suarez"); 
		  
		  Integer id = 1;
			 String nombreCurso = "Introduccion a la programacion";
		  Integer capacidad = 100;
		  String lenguajePrincipal = "Java";
		  Curso cursoProgramacion = new CursoProgramacion(id, nombreCurso, capacidad, lenguajePrincipal);
	  
		  Sistema sistema = new Sistema(); 
		  sistema.agregarCurso(cursoProgramacion);
		  sistema.anadirProfesor(profesor);
		  sistema.anadirAlumno(alumno);
		  sistema.anadirProfesorACurso(profesor, cursoProgramacion); 
		  sistema.anadirAlumnoACurso(alumno, cursoProgramacion);
	  
		  LocalDate fechaLimite = LocalDate.of(2025, 10, 20); 
		  TrabajoPractico trabajoPractico = new TrabajoPractico(fechaLimite, cursoProgramacion);
		  
		  profesor.asignarTrabajoPracticoACurso(trabajoPractico, cursoProgramacion);
	  
		  LocalDate fechaEntrega = LocalDate.of(2025, 10, 15);
		  alumno.entregarTrabajoPractico(trabajoPractico, fechaEntrega);
			 
		  Integer nota = 7;
		  EntregaTrabajoPractico entregaTrabajoPractico = profesor.getEntregasDeTrabajosPracticos().get(0);
		  
		  profesor.corregirEntregaTrabajoPractico(entregaTrabajoPractico, nota); 
	  
		  Integer notaEsperada = 7; 
		  Integer notaObtenida = entregaTrabajoPractico.getNota();
	  
		  assertEquals(notaEsperada, notaObtenida); 
	 }
	
	 @Test public void dadoQueExisteUnProfesorConElMetodoAsignarTrabajoPracticoACursoDichoTrabajoPracticoEsAnadidoALaListaDeTrabajosPracticosDeTodosLosAlumnosInscriptosEnElCurso() { 
		 Profesor profesor = new Profesor(21330190, "Juancito", "Suarez"); 
		 Alumno alumnoUno = new Alumno(21330190, "Juancito", "Suarez"); 
		 Alumno alumnoDos = new Alumno(21330190, "Juancito", "Suarez");
		 
		 Integer id = 1;
		 String nombreCurso = "Introduccion a la programacion";
		 Integer capacidad = 100;
		 String lenguajePrincipal = "Java";
		 Curso cursoProgramacion = new CursoProgramacion(id, nombreCurso, capacidad, lenguajePrincipal);
	  
		 Sistema sistema = new Sistema(); 
		 sistema.agregarCurso(cursoProgramacion);
		 sistema.anadirProfesor(profesor);
		 sistema.anadirAlumno(alumnoUno);
		 sistema.anadirAlumno(alumnoDos);
		 sistema.anadirProfesorACurso(profesor, cursoProgramacion); 
		 sistema.anadirAlumnoACurso(alumnoUno, cursoProgramacion);
		 sistema.anadirAlumnoACurso(alumnoDos, cursoProgramacion);
	  
		 LocalDate fechaEntrega = LocalDate.of(2025, 10, 20); 
		 TrabajoPractico trabajoPractico = new TrabajoPractico(fechaEntrega, cursoProgramacion);
	  
		 profesor.asignarTrabajoPracticoACurso(trabajoPractico, cursoProgramacion);
	  
		 assertTrue(alumnoUno.getTrabajosPracticos().contains(trabajoPractico));
		 assertTrue(alumnoDos.getTrabajosPracticos().contains(trabajoPractico)); 
	 }
	
	 @Test public void dadoQueExisteUnProfesorConElMetodoCorregirEntregaTrabajoPracticoSeAgregaLaNotaObtenidaALaListaDeNotasCorrespondienteALaInscripcionQueRelacionaAlAlumnoConElCurso() { 
		 Integer dni = 123;
		 String nombre = "nombre";
		 String apellido = "apellido";
		 Alumno alumno = new Alumno(dni, nombre, apellido);
		
		 Profesor profesor = new Profesor(dni, nombre, apellido);
			
		 Integer id = 1;
		 String nombreCurso = "Introduccion a la programacion";
		 Integer capacidad = 100;
		 String lenguajePrincipal = "Java";
		 Curso cursoProgramacion = new CursoProgramacion(id, nombreCurso, capacidad, lenguajePrincipal);
					
		 Sistema sistema = new Sistema(); 
		 sistema.agregarCurso(cursoProgramacion);
		 sistema.anadirProfesor(profesor);
		 sistema.anadirAlumno(alumno);
		 sistema.anadirProfesorACurso(profesor, cursoProgramacion); 
		 sistema.anadirAlumnoACurso(alumno, cursoProgramacion);
		 
		 LocalDate fechaLimite = LocalDate.of(2025, 10, 20); 
		 
		 TrabajoPractico trabajoPractico = new TrabajoPractico(fechaLimite, cursoProgramacion);
		 
		 profesor.asignarTrabajoPracticoACurso(trabajoPractico, cursoProgramacion);
		 
		 LocalDate fechaEntrega = LocalDate.of(2025, 10, 15);
		 alumno.entregarTrabajoPractico(trabajoPractico, fechaEntrega);
		 
		 Integer nota = 7;
		 EntregaTrabajoPractico entregaTrabajoPractico = profesor.getEntregasDeTrabajosPracticos().get(0);
		 profesor.corregirEntregaTrabajoPractico(entregaTrabajoPractico, nota); 
		 
		 List<Inscripcion> inscripciones = new ArrayList<>(sistema.getInscripciones());
		 assertTrue(inscripciones.get(0).getNotas().contains(nota)); 
	 }
}
