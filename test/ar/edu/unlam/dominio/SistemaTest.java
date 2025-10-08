package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;


public class SistemaTest {
	
	@Test
	public void dadoQueExisteUnSistemaElMetodoAgregarCursoDevuelveTrue() {
		Curso curso = new CursoProgramacion(1, "PB2", 20, "Java");
		Sistema sistema = new Sistema();

		assertTrue(sistema.agregarCurso(curso));
	}
	
	@Test
	public void dadoQueExisteUnSistemaElMetodoAnadirAlumnoACursoDevuelveTrue() {
		Alumno alumno = new Alumno(24330190, "Pepito", "Suarez");
		Double promedioFinalConElQueSeAprueba = 7.0;
		Curso curso = new CursoDisenio(1, "PB2", 20, "Photoshop", promedioFinalConElQueSeAprueba);
		Sistema sistema = new Sistema();
		sistema.agregarCurso(curso);
		sistema.anadirAlumno(alumno);
		
		assertTrue(sistema.anadirAlumnoACurso(alumno, curso));
	}
	
	@Test
	public void dadoQueExisteUnSistemaConElMetodoAnadirAlumnoACursoDichoMetodoAnadeAlAlumnoALaListaDeAlumnosDelCurso() {
		Alumno alumno = new Alumno(24330190, "Pepito", "Suarez");
		
		Double promedioFinalConElQueSeAprueba = 7.0;
		Curso curso = new CursoDisenio(1, "PB2", 20, "Photoshop", promedioFinalConElQueSeAprueba);
		Sistema sistema = new Sistema();
		sistema.agregarCurso(curso);
		sistema.anadirAlumnoACurso(alumno, curso);
		
		assertTrue(curso.getAlumnos().contains(alumno));
	}
	
	@Test
	public void dadoQueExisteUnSistemaConElMetodoAnadirProfesorACursoDichoMetodoActualizaElAtributoProfesorDelCurso() {
		Profesor profesor = new Profesor(24330190, "Pepito", "Suarez");
		
		Double promedioFinalConElQueSeAprueba = 7.0;
		Curso curso = new CursoDisenio(1, "PB2", 20, "Photoshop", promedioFinalConElQueSeAprueba);
		Sistema sistema = new Sistema();
		sistema.agregarCurso(curso);
		sistema.anadirProfesor(profesor);
		sistema.anadirProfesorACurso(profesor, curso);

		assertTrue(curso.getProfesor().equals(profesor));
	}
	
	@Test
	public void dadoQueExisteUnSistemaElMetodoAnadirProfesorACursoDevuelveTrue() {
		Profesor profesor = new Profesor(22330190, "Juancito", "Perez");
		Curso curso = new CursoProgramacion(1, "PB2", 20, "Java");
		Sistema sistema = new Sistema();
		sistema.agregarCurso(curso);
		sistema.anadirProfesor(profesor);
		
		assertTrue(sistema.anadirProfesorACurso(profesor, curso));
	}
	
	@Test
	public void dadoQueExisteUnSistemaConUnaListaDeInscripcionesElMetodoAnadirAlumnoACursoAnadeUnaInscripcionADichaLista() {
		Curso curso = new CursoProgramacion(1, "PB2", 20, "Java");
		Alumno alumno = new Alumno(24330190, "Pepito", "Suarez");
		Sistema sistema = new Sistema();
		sistema.agregarCurso(curso);
		sistema.anadirAlumno(alumno);
		sistema.anadirAlumnoACurso(alumno, curso);
		
		Integer tamanoEsperado = 1;
		Integer tamanoObtenido = sistema.getInscripciones().size();
		
		assertEquals(tamanoEsperado, tamanoObtenido);
	}
	
	@Test
	public void dadoQueYaExisteUnProfesorAsignadoAlCursoNoSePermiteAsignarloNuevamente() {
		Curso curso = new CursoProgramacion(1, "PB2", 20, "Java");
		Profesor profesor = new Profesor(22330190, "Juancito", "Perez");
		Sistema sistema = new Sistema();
		sistema.agregarCurso(curso);
		sistema.anadirProfesor(profesor);
		sistema.agregarCurso(curso);
		
		assertTrue(sistema.anadirProfesorACurso(profesor, curso));
		
		assertFalse(sistema.anadirProfesorACurso(profesor, curso));
	}
	
	@Test
    public void dadoQueExisteUnSistemaElMetodoObtenerCursosDeAlumnoDevuelveLosCursosCorrectos() {
        Sistema sistema = new Sistema();

        Alumno alumno = new Alumno(33333333, "Luis", "Martinez");

        Curso cursoUno = new CursoProgramacion(1, "PB2", 20, "Java");
        
        Double promedioFinalConElQueSeAprueba = 7.0;
        Curso cursoDos = new CursoDisenio(2, "Diseño Gráfico", 15, "Photoshop", promedioFinalConElQueSeAprueba);

        sistema.agregarCurso(cursoUno);
        sistema.agregarCurso(cursoDos);

        sistema.anadirAlumno(alumno);
        sistema.anadirAlumnoACurso(alumno, cursoUno);
        sistema.anadirAlumnoACurso(alumno, cursoDos);

        List<Curso> cursosDelAlumno = sistema.obtenerCursosDeUnAlumno(alumno);
        
        Integer tamañoEsperado = 2;
        Integer tamañoObtenido = cursosDelAlumno.size();
        
        assertEquals(tamañoEsperado, tamañoObtenido);
        assertTrue(cursosDelAlumno.contains(cursoUno));
        assertTrue(cursosDelAlumno.contains(cursoDos));
    }
	
	@Test
    public void dadoQueExisteUnSistemaElMetodoObtenerAlumnosInscriptosAUnCursoDevuelveLosAlumnosInscriptosADichoCurso() {
        Sistema sistema = new Sistema();

        Alumno alumnoUno = new Alumno(11111111, "Juan", "Perez");
        Alumno alumnoDos = new Alumno(22222222, "Ana", "Lopez");

        Curso curso = new CursoProgramacion(1, "PB2", 20, "Java");

        sistema.agregarCurso(curso);
        sistema.anadirAlumno(alumnoUno);
        sistema.anadirAlumno(alumnoDos);

        sistema.anadirAlumnoACurso(alumnoUno, curso);
        sistema.anadirAlumnoACurso(alumnoDos, curso);

        List<Alumno> alumnosInscriptos = sistema.obtenerAlumnosInscriptosAUnCurso(curso);
        
        Integer tamañoEsperado = 2;
        Integer tamañoObtenido = alumnosInscriptos.size();
        
        assertEquals(tamañoEsperado, tamañoObtenido);
        assertTrue(alumnosInscriptos.contains(alumnoUno));
        assertTrue(alumnosInscriptos.contains(alumnoDos));
    }
}