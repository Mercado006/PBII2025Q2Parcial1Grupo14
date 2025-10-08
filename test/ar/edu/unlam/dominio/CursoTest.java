package ar.edu.unlam.dominio;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Test;

public class CursoTest {
	
	@Test
    public void dadoQueExisteUnCursoQueImplementaLaInterfazEvaluableSiUnAlumnoEntrega2TPsConNotasCuyoPromedioNoEsSuficienteParaAprobarEntoncesElMetodoEstaAprobadoRetornaFalse() {
        CursoDisenio curso = new CursoDisenio(1, "Diseño Gráfico", 10, "Photoshop", 7.0);

        Alumno alumno = new Alumno(123, "Juan", "Perez");
        Profesor profesor = new Profesor(456, "Ana", "Gomez");

        Sistema sistema = new Sistema();
        sistema.agregarCurso(curso);
        sistema.anadirProfesor(profesor);
        sistema.anadirAlumno(alumno);
        sistema.anadirProfesorACurso(profesor, curso);
        sistema.anadirAlumnoACurso(alumno, curso);

        TrabajoPractico tp1 = new TrabajoPractico(LocalDate.of(2025, 10, 20), curso);
        TrabajoPractico tp2 = new TrabajoPractico(LocalDate.of(2025, 10, 20), curso);

        profesor.asignarTrabajoPracticoACurso(tp1, curso);
        profesor.asignarTrabajoPracticoACurso(tp2, curso);

        alumno.entregarTrabajoPractico(tp1, LocalDate.of(2025, 10, 18));
        alumno.entregarTrabajoPractico(tp2, LocalDate.of(2025, 10, 19));

        profesor.corregirEntregaTrabajoPractico(profesor.getEntregasDeTrabajosPracticos().get(0), 5);
        profesor.corregirEntregaTrabajoPractico(profesor.getEntregasDeTrabajosPracticos().get(1), 6);

        Double promedioFinal = alumno.obtenerInscripcionPorCurso(curso).calcularPromedio();

        assertFalse(curso.estaAprobado(promedioFinal));
    }
	
	@Test
    public void dadoQueExisteUnCursoQueImplementaLaInterfazEvaluableSiUnAlumnoEntrega2TPsConNotasCuyoPromedioEsSuficienteParaAprobarEntoncesElMetodoEstaAprobadoRetornaTrue() {
        CursoDisenio curso = new CursoDisenio(2, "Diseño Gráfico", 10, "Photoshop", 7.0);

        Alumno alumno = new Alumno(321, "Laura", "Martinez");
        Profesor profesor = new Profesor(654, "Carlos", "Lopez");

        Sistema sistema = new Sistema();
        sistema.agregarCurso(curso);
        sistema.anadirProfesor(profesor);
        sistema.anadirAlumno(alumno);
        sistema.anadirProfesorACurso(profesor, curso);
        sistema.anadirAlumnoACurso(alumno, curso);

        TrabajoPractico tp1 = new TrabajoPractico(LocalDate.of(2025, 10, 20), curso);
        TrabajoPractico tp2 = new TrabajoPractico(LocalDate.of(2025, 10, 20), curso);

        profesor.asignarTrabajoPracticoACurso(tp1, curso);
        profesor.asignarTrabajoPracticoACurso(tp2, curso);

        alumno.entregarTrabajoPractico(tp1, LocalDate.of(2025, 10, 18));
        alumno.entregarTrabajoPractico(tp2, LocalDate.of(2025, 10, 19));

        profesor.corregirEntregaTrabajoPractico(profesor.getEntregasDeTrabajosPracticos().get(0), 8);
        profesor.corregirEntregaTrabajoPractico(profesor.getEntregasDeTrabajosPracticos().get(1), 9);

        Double promedioFinal = alumno.obtenerInscripcionPorCurso(curso).calcularPromedio();

        assertTrue(curso.estaAprobado(promedioFinal));
    }
	
	@Test
	public void dadoQueExisteUnCursoElMetodoAnadirAlumnoDevuelveTrue() {
		Alumno alumno = new Alumno(24330190, "Pepito", "Suarez");
		Curso curso = new CursoProgramacion(1, "PB2", 20, "Java");
		Sistema sistema = new Sistema();
		sistema.agregarCurso(curso);
		
		assertTrue(curso.anadirAlumno(alumno));
	}
	
	@Test
	public void dadoQueExisteUnCursoElMetodoAnadirProfesorDevuelveTrue() {
		Profesor profesor = new Profesor(24330190, "Pepito", "Suarez");
		Curso curso = new CursoProgramacion(1, "PB2", 20, "Java");
		Sistema sistema = new Sistema();
		sistema.agregarCurso(curso);
		
		assertTrue(sistema.anadirProfesor(profesor));
	}
	
	@Test
	public void dadoQueExisteUnCursoConUnaListaDeAlumnosElMetodoAnadirAlumnoAgregaDichoAlumnoASuLista() {
		Alumno alumno = new Alumno(24330190, "Pepito", "Suarez");
		Curso curso = new CursoProgramacion(1, "PB2", 20, "Java");
		Sistema sistema = new Sistema();
		sistema.agregarCurso(curso);
		
		curso.anadirAlumno(alumno);
		
		Integer tamañoEsperado = 1;
		Integer tamañoObtenido = curso.getAlumnos().size();
		
		assertEquals(tamañoEsperado, tamañoObtenido);
		assertTrue(curso.getAlumnos().contains(alumno));
	}
	
	@Test
	public void dadoQueExisteUnCursoConUnAtributoProfesorElMetodoAnadirProfesorActualizaDichoAtributo() {
		Profesor profesor = new Profesor(24330190, "Pepito", "Suarez");
		Curso curso = new CursoProgramacion(1, "PB2", 20, "Java");
		Sistema sistema = new Sistema();
		sistema.agregarCurso(curso);
		
		curso.anadirProfesor(profesor);
		
		Profesor profesorEsperado = profesor;
		Profesor profesorObtenido = curso.getProfesor();
		
		assertEquals(profesorEsperado, profesorObtenido);
	}
	
	@Test
	public void dadoQueExisteUnCursoYQueNoQuedanCuposEnElCursoNoSePuedeAnadirAlAlumno() {
		Curso curso = new CursoProgramacion(1, "PB2", 1, "Java");
		Alumno alumno1 = new Alumno(24330190, "Pepito", "Suarez");
		Alumno alumno2 = new Alumno(23230190, "Jose", "Suarez");
		Sistema sistema = new Sistema();
		sistema.agregarCurso(curso);
		sistema.anadirAlumno(alumno1);
		sistema.anadirAlumno(alumno2);
		sistema.anadirAlumnoACurso(alumno1, curso);
		
		assertFalse(sistema.anadirAlumnoACurso(alumno2, curso));
	}
}
