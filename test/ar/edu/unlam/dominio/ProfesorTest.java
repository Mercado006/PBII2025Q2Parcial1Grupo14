package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

public class ProfesorTest {
	
	@Test
	public void dadoQueExisteUnProfesorConElMetodoObtenerEntregasDeTrabajosPracticosSinCorregirDevuelveUnaListaDeEntregaTrabajoPracticoCuyoAtributoCorregidoSeaFalse() {
	// Testea el metodo de Profesor obtenerEntregasDeTrabajosPracticosSinCorregir y verifica que en la lista que se devuelvan solamente existan aquellas EntregaTrabajoPractico cuyo Boolean corregido sea false.
		Profesor profesor = new Profesor(21330190, "Juancito", "Suarez");
		Alumno alumno = new Alumno(24330190, "Pepito", "Suarez");
		Curso curso = new Curso(1, "PB2", 20);
		
		Sistema sistema = new Sistema();
		sistema.agregarCurso(curso);
		sistema.anadirProfesor(profesor);
		sistema.anadirAlumnoACurso(alumno, curso);

		LocalDate fechaEntrega = LocalDate.of(2025, 10, 20);
		EntregaTrabajoPractico entregaTrabajoPracticoUno = new EntregaTrabajoPractico(alumno, fechaEntrega, curso);
		EntregaTrabajoPractico entregaTrabajoPracticoDos = new EntregaTrabajoPractico(alumno, fechaEntrega, curso);
		EntregaTrabajoPractico entregaTrabajoPracticoTres = new EntregaTrabajoPractico(alumno, fechaEntrega, curso);

		profesor.recibirEntregaTrabajoPractico(entregaTrabajoPracticoUno);
		profesor.recibirEntregaTrabajoPractico(entregaTrabajoPracticoDos);
		profesor.recibirEntregaTrabajoPractico(entregaTrabajoPracticoTres);

		profesor.corregirEntregaTrabajoPractico(entregaTrabajoPracticoUno);
		
		List<EntregaTrabajoPractico> entregasDetrabajosPracticosSinCorregirObtenidos = profesor.obtenerEntregaDeTrabajosPracticosSinCorregir();
		
		assertTrue(entregasDetrabajosPracticosSinCorregirObtenidos.contains(entregaTrabajoPracticoDos));
		assertTrue(entregasDetrabajosPracticosSinCorregirObtenidos.contains(entregaTrabajoPracticoTres));
		
		Integer tamanioEsperado = 2;
		Integer tamanioObtenido = entregasDetrabajosPracticosSinCorregirObtenidos.size();
		
		assertEquals(tamanioEsperado, tamanioObtenido);
	}
	
	/*
	 * @Test public void
	 * dadoQueExisteUnProfesorConElMetodoCorregirEntregaTrabajoPracticoSeActualizaElEstadoCorregidoDeEntregaTrabajoPracticoATrue
	 * () { // Testea el metodo de Profesor corregirEntregaTrabajoPractico y
	 * verifica con un entregaTrabajoPractico.getCorregido() que efectivamente se
	 * haya actualizado el estado del atributo a true. Profesor profesor = new
	 * Profesor(21330190, "Juancito", "Suarez"); Alumno alumno = new
	 * Alumno(24330190, "Pepito", "Suarez"); Curso curso = new Curso(1, "PB2", 20);
	 * 
	 * Sistema sistema = new Sistema(); sistema.agregarCurso(curso);
	 * sistema.anadirProfesor(profesor); sistema.anadirAlumnoACurso(alumno, curso);
	 * 
	 * LocalDate fechaEntrega = LocalDate.of(2025, 10, 20); EntregaTrabajoPractico
	 * entregaTrabajoPractico = new EntregaTrabajoPractico(alumno, fechaEntrega,
	 * curso);
	 * 
	 * profesor.recibirEntregaTrabajoPractico(entregaTrabajoPractico);
	 * 
	 * Integer nota = 7;
	 * profesor.corregirEntregaTrabajoPractico(entregaTrabajoPractico, nota);
	 * 
	 * Boolean estadoCorregidoEsperado = true; Boolean estadoCorregidoObtenido =
	 * entregaTrabajoPractico.getFueCorregido();
	 * 
	 * assertEquals(estadoCorregidoEsperado, estadoCorregidoObtenido); }
	 * 
	 * @Test public void
	 * dadoQueExisteUnProfesorConElMetodoRecibirEntregaTrabajoPracticoDichaEntregaTrabajoPracticoSeAgregaASuListaDeEntregasDeTrabajosPracticos
	 * () { // Testea el metodo de Profesor recibirEntregaTrabajoPractico para
	 * verificar que efectivamente se anada el trabajo practico a su lista. Profesor
	 * profesor = new Profesor(21330190, "Juancito", "Suarez"); Alumno alumno = new
	 * Alumno(24330190, "Pepito", "Suarez"); Curso curso = new Curso(1, "PB2", 20);
	 * 
	 * Sistema sistema = new Sistema(); sistema.agregarCurso(curso);
	 * sistema.anadirProfesor(profesor); sistema.anadirAlumnoACurso(alumno, curso);
	 * 
	 * LocalDate fechaEntrega = LocalDate.of(2025, 10, 20); EntregaTrabajoPractico
	 * entregaTrabajoPractico = new EntregaTrabajoPractico(alumno, fechaEntrega,
	 * curso);
	 * 
	 * profesor.recibirEntregaTrabajoPractico(entregaTrabajoPractico);
	 * 
	 * assertTrue(profesor.getTrabajosPractico.contains(entregaTrabajoPractico)); }
	 * 
	 * @Test public void
	 * dadoQueExisteUnProfesorConElMetodoCorregirEntregaTrabajoPracticoSeActualizaLaNotaDeLaEntregaTrabajoPractico
	 * () { // Testea el metodo de Profesor corregirEntregaTrabajoPractico y
	 * verifica con un entregaTrabajoPractico.getNota() que efectivamente se haya
	 * actualizado el atributo. Profesor profesor = new Profesor(21330190,
	 * "Juancito", "Suarez"); Alumno alumno = new Alumno(24330190, "Pepito",
	 * "Suarez"); Curso curso = new Curso(1, "PB2", 20);
	 * 
	 * Sistema sistema = new Sistema(); sistema.agregarCurso(curso);
	 * sistema.anadirProfesor(profesor); sistema.anadirAlumnoACurso(alumno, curso);
	 * 
	 * LocalDate fechaEntrega = LocalDate.of(2025, 10, 20); EntregaTrabajoPractico
	 * entregaTrabajoPractico = new EntregaTrabajoPractico(alumno, fechaEntrega,
	 * curso);
	 * 
	 * profesor.recibirEntregaTrabajoPractico(entregaTrabajoPractico);
	 * 
	 * Integer nota = 7;
	 * profesor.corregirEntregaTrabajoPractico(entregaTrabajoPractico, nota);
	 * 
	 * Integer notaEsperada = 7; Integer notaObtenida =
	 * entregaTrabajoPractico.getNota();
	 * 
	 * assertEquals(notaEsperada, notaObtenida); }
	 * 
	 * @Test public void
	 * dadoQueExisteUnProfesorConElMetodoAsignarTrabajoPracticoACursoDichoTrabajoPracticoEsAnadidoALaListaDeTrabajosPracticosDeTodosLosAlumnosInscriptosEnElCurso
	 * () { // Testea el metodo de Profesor para que efectivamente asigne el T.P. a
	 * todos los alumnos inscriptos en el curso. Profesor profesor = new
	 * Profesor(21330190, "Juancito", "Suarez"); Alumno alumnoUno = new
	 * Alumno(21330190, "Juancito", "Suarez"); Alumno alumnoDos = new
	 * Alumno(21330190, "Juancito", "Suarez"); Curso curso = new Curso(1, "PB2",
	 * 20);
	 * 
	 * Sistema sistema = new Sistema(); sistema.agregarCurso(curso);
	 * sistema.anadirProfesor(profesor); sistema.anadirProfesorACurso(profesor,
	 * curso); sistema.inscribirAlumno(alumnoUno, curso);
	 * sistema.inscribirAlumno(alumnoDos, curso);
	 * 
	 * LocalDate fechaEntrega = LocalDate.of(2025, 10, 20); TrabajoPractico
	 * trabajoPractico = new TrabajoPractico(fechaEntrega, curso);
	 * 
	 * profesor.asignarTrabajoPracticoACurso(trabajoPractico, curso);
	 * 
	 * assertTrue(alumnoUno.getTrabajosPracticos.contains(trabajoPractico));
	 * assertTrue(alumnoDos.getTrabajosPracticos.contains(trabajoPractico)); }
	 * 
	 * @Test public void
	 * dadoQueExisteUnProfesorConElMetodoCorregirEntregaTrabajoPracticoSeAgregaLaNotaObtenidaALaListaDeNotasCorrespondienteALaInscripcionQueRelacionaAlAlumnoConElCurso
	 * () { Profesor profesor = new Profesor(); Alumno alumno = new Alumno(); Curso
	 * curso = new Curso();
	 * 
	 * Sistema sistema = new Sistema(); sistema.agregarCurso(curso);
	 * sistema.anadirProfesor(profesor, curso); sistema.inscribirAlumno(alumno,
	 * curso);
	 * 
	 * LocalDate fechaEntrega = LocalDate.of(2025, 10, 20); EntregaTrabajoPractico
	 * entregaTrabajoPractico = new EntregaTrabajoPractico(alumno, fechaEntrega,
	 * curso);
	 * 
	 * profesor.recibirEntregaTrabajoPractico(entregaTrabajoPractico);
	 * 
	 * Integer nota = 7;
	 * profesor.corregirEntregaTrabajoPractico(entregaTrabajoPractico, nota);
	 * 
	 * List<Inscripcion> inscripiones = new
	 * ArrayList<>(sistema.obtenerInscripciones());
	 * assertTrue(inscripciones.get(0).getNotas().contains(nota)); }
	 */
	


}
