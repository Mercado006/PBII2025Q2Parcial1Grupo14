package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;

public class EntregaTrabajoPracticoTest {
	
	@Test
    public void dadoQueExisteUnaEntregaTrabajoPracticoConElAtributoBooleanFueCorregidoCuandoSeInstanciaElObjetoDichoAtributoEsFalse() {
        Alumno alumno = new Alumno(123, "Juan", "Perez");
        CursoMusica curso = new CursoMusica(2, "Música", 10, "Guitarra", 6.0);
        LocalDate fechaEntrega = LocalDate.of(2025, 10, 20);

        EntregaTrabajoPractico entrega = new EntregaTrabajoPractico(alumno, fechaEntrega, curso);
        
        Boolean estadoCorregidoEsperado = false;
        Boolean estadoCorregidoObtenido = entrega.getFueCorregido();
        
        assertEquals(estadoCorregidoEsperado, estadoCorregidoObtenido);
    }
	
	@Test
    public void dadoQueExisteUnaEntregaTrabajoPracticoConElAtributoIntegerNotaCuandoSeInstanciaElObjetoDichoAtributoEsNull() {
        Alumno alumno = new Alumno(123, "Juan", "Perez");
        CursoMusica curso = new CursoMusica(2, "Música", 10, "Guitarra", 6.0);
        LocalDate fechaEntrega = LocalDate.of(2025, 10, 20);

        EntregaTrabajoPractico entrega = new EntregaTrabajoPractico(alumno, fechaEntrega, curso);
        
        Integer notaEsperada = null;
        Integer notaObtenida = entrega.getNota();
        
        assertEquals(notaEsperada, notaObtenida);
    }
	
	@Test
    public void dadoQueExisteUnaEntregaTrabajoPracticoConElAtributoIntegerNotaElMetodoSetNotaActualizaDichoAtributo() {
        Alumno alumno = new Alumno(123, "Juan", "Perez");
        CursoMusica curso = new CursoMusica(2, "Música", 10, "Guitarra", 6.0);
        LocalDate fechaEntrega = LocalDate.of(2025, 10, 20);

        EntregaTrabajoPractico entrega = new EntregaTrabajoPractico(alumno, fechaEntrega, curso);
        
        Integer nota = 7;
        entrega.setNota(nota);
        
        Integer notaEsperada = 7;
        Integer notaObtenida = entrega.getNota();
        
        assertEquals(notaEsperada, notaObtenida);
    }
	
	@Test
    public void dadoQueExisteUnaEntregaTrabajoPracticoConElAtributoBooleanFueCorregidoElMetodoSetCorregidoActualizaDichoAtributo() {
        Alumno alumno = new Alumno(123, "Juan", "Perez");
        CursoMusica curso = new CursoMusica(2, "Música", 10, "Guitarra", 6.0);
        LocalDate fechaEntrega = LocalDate.of(2025, 10, 20);

        EntregaTrabajoPractico entrega = new EntregaTrabajoPractico(alumno, fechaEntrega, curso);

        entrega.setFueCorregido(true);

        assertTrue(entrega.getFueCorregido());
    }
}
