package ar.edu.unlam.dominio;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestsSistemaGestion {
	
	@Test
	public void crearUnCursoYAgregarloAlSistema() {
		Curso curso = new Curso();
		Sistema sistema = new Sistema();

		assertTrue(sistema.agregarCurso(curso));
		
	}
	
	
	
	
}
