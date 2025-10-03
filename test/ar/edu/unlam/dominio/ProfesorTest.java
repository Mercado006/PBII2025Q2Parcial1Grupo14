package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

public class ProfesorTest {
	
	@Test
	public void dadoQueExisteUnProfesorConElMetodoObtenerTrabajosPracticosSinCorregirDevuelveUnaListaDeTrabajosPracticosCuyoAtributoCorregidoSeaFalse() {
	// Testea el m�todo de Profesor obtenerTrabajosPracticosSinCorregir y verifica que en la lista que se devolvi� solamente existan aquellos trabajosPracticos cuyo Boolean corregido est� seteado a false.
		Profesor profesor = new Profesor();
		
		Curso curso = new Curso();
		// El profesor se tendr�a que incorporar al curso

		LocalDate fechaEntrega = LocalDate.of(2025, 10, 20);
		TrabajoPractico trabajoPracticoUno = new TrabajoPractico(fechaEntrega, curso);
		TrabajoPractico trabajoPracticoDos = new TrabajoPractico(fechaEntrega, curso);
		TrabajoPractico trabajoPracticoTres = new TrabajoPractico(fechaEntrega, curso);

		profesor.recibirTrabajoPractico(trabajoPracticoUno);
		profesor.recibirTrabajoPractico(trabajoPracticoDos);
		profesor.recibirTrabajoPractico(trabajoPracticoTres);

		profesor.corregirTrabajoPractico(trabajoPracticoUno);
		
		List<TrabajoPractico> trabajosPracticosSinCorregirObtenidos = profesor.obtenerTrabajosPracticosSinCorregir();
		
		assertTrue(trabajosPracticosSinCorregirObtenidos.contains(trabajoPracticoDos));
		assertTrue(trabajosPracticosSinCorregirObtenidos.contains(trabajoPracticoTres));
		
		Integer tamanioEsperado = 2;
		Integer tamanioObtenido = trabajosPracticosSinCorregirObtenidos.size();
		
		assertEquals(tamanioEsperado, tamanioObtenido);
	}
	
	@Test	
	public void dadoQueExisteUnProfesorConElMetodoCorregirTrabajoPracticoSeActualizaElEstadoCorregidoDeTrabajoPracticoATrue() {
	// Testea el m�todo de Profesor corregirTrabajoPractico y verifica con un trabajoPractico.getCorregido() que efectivamente se haya actualizado el estado del atributo a true.
		Profesor profesor = new Profesor();
		
		Curso curso = new Curso();
		// El profesor se tendr�a que incorporar al curso

		LocalDate fechaEntrega = LocalDate.of(2025, 10, 20);
		TrabajoPractico trabajoPractico = new TrabajoPractico(fechaEntrega, curso);
		
		profesor.recibirTrabajoPractico(trabajoPractico);
		
		Integer nota = 7;
		profesor.corregirTrabajoPractico(trabajoPractico, nota);
		
		Boolean estadoCorregidoEsperado = true;
		Boolean estadoCorregidoObtenido = trabajoPractico.getFueCorregido();
		
		assertEquals(estadoCorregidoEsperado, estadoCorregidoObtenido);
	}
	
	@Test	
	public void dadoQueExisteUnProfesorConElMetodoRecibirTrabajoPracticoDichoTrabajoSeAgregaASuListaDeTrabajosPracticos() {
	// Testea el m�todo de Profesor recibirTrabajoPractico para verificar que efectivamente se a�ada el trabajo pr�ctico a su lista.
		Profesor profesor = new Profesor();
		
		Curso curso = new Curso();
		// El profesor se tendr�a que incorporar al curso

		LocalDate fechaEntrega = LocalDate.of(2025, 10, 20);
		TrabajoPractico trabajoPractico = new TrabajoPractico(fechaEntrega, curso);
		
		profesor.recibirTrabajoPractico(trabajoPractico);
		
		assertTrue(profesor.getListaDeTrabajosPracticos.contains(trabajoPractico));
	}
	
	@Test	
	public void dadoQueExisteUnProfesorConElMetodoCorregirTrabajoPracticoSeActualizaLaNotaDelTrabajoPractico() {
	// Testea el m�todo de Profesor corregirTrabajoPractico y verifica con un trabajoPractico.getNota() que efectivamente se haya actualizado el atributo.
		Profesor profesor = new Profesor();
		
		Curso curso = new Curso();
		// El profesor se tendr�a que incorporar al curso

		LocalDate fechaEntrega = LocalDate.of(2025, 10, 20);
		TrabajoPractico trabajoPractico = new TrabajoPractico(fechaEntrega, curso);
		
		profesor.recibirTrabajoPractico(trabajoPractico);
		
		Integer nota = 7;
		profesor.corregirTrabajoPractico(trabajoPractico, nota);
		
		Integer notaEsperada = 7;
		Integer notaObtenida = trabajoPractico.getNota();
		
		assertEquals(notaEsperada, notaObtenida);
	}
	
	@Test
	public void dadoQueExisteUnProfesorConElMetodoAsignarTrabajoPracticoACursoDichoTrabajoPracticoEsAniadidoALaListaDeTrabajosPracticosDeTodosLosAlumnosInscriptosEnElCurso() {
	// Testea el m�todo de Profesor para que efectivamente asigne el T.P. a todos los alumnos inscriptos en el curso.
		Profesor profesor = new Profesor();
		
		Alumno alumnoUno = new Alumno();
		Alumno alumnoDos = new Alumno();
		
		Curso curso = new Curso();
		// Ac� se tendr�an que incorporar los alumnos al curso, junto al profesor
		
		LocalDate fechaEntrega = LocalDate.of(2025, 10, 20);
		TrabajoPractico trabajoPractico = new TrabajoPractico(fechaEntrega, curso);
		
		profesor.asignarTrabajoPracticoACurso(trabajoPractico, curso);
		
		assertTrue(alumnoUno.getTrabajosPracticos.contains(trabajoPractico));
		assertTrue(alumnoDos.getTrabajosPracticos.contains(trabajoPractico));
	}
	
	@Test
	public void asignarProfesorAUnCurso() {
		Curso curso = new Curso();
		Profesor profesor = new Profesor(); //esto para mi tiene que ser una relacion 1 a N, siendo profesor la N
		
		assertTrue(profesor.agregarCurso(curso));
	}

}
