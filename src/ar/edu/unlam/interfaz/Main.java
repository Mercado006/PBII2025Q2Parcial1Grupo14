package ar.edu.unlam.interfaz;

import java.time.LocalDate;
import java.util.Scanner;

import ar.edu.unlam.dominio.Alumno;
import ar.edu.unlam.dominio.Curso;
import ar.edu.unlam.dominio.CursoProgramacion;
import ar.edu.unlam.dominio.Profesor;
import ar.edu.unlam.dominio.Sistema;
import ar.edu.unlam.dominio.TrabajoPractico;
import ar.edu.unlam.interfaz.enums.Opciones;

public class Main {

	private static final Scanner TECLADO = new Scanner(System.in);

	public static void main(String[] args) {
		
		Sistema sistema = new Sistema();

		mensajeConsola("Bienvenido al Gestor de Cursos Online.");

		Opciones opcionIngresada = null;

		do {

			opcionIngresada = ingresarOpcionMenuPrincipal();

			switch (opcionIngresada) {
			case AGREGAR_ALUMNO:
				agregarAlumno(sistema);
				break;

			case AGREGAR_PROFESOR:
				agregarProfesor(sistema);
				break;

			case AGREGAR_CURSO:
				agregarCurso(sistema);
				break;

			case ASIGNAR_TRABAJO_PRACTICO:

				mensajeConsola("\nIngrese el DNI del profesor que realizará la asignación del trabajo práctico: ");
				Integer dniProfesorIngresado2 = TECLADO.nextInt();

				Profesor profesorEncontrado = null;
				for (Profesor profesor : sistema.getProfesores()) {
					if (profesor.getDni().equals(dniProfesorIngresado2)) {
						profesorEncontrado = profesor;
						break;
					}
				}

				mensajeConsola("\nIngrese el ID del curso al que se le asociará el trabajo práctico: ");
				Integer idCursoIngresado3 = TECLADO.nextInt();

				Curso cursoEncontrado2 = null;
				for (Curso cursito : sistema.getCursos()) {
					if (cursito.getIdCurso().equals(idCursoIngresado3)) {
						cursoEncontrado2 = cursito;
						break;
					}
				}

				mensajeConsola("\nFechas de entrega: ");
				mensajeConsola("Ingrese el AÑO DE ENTREGA: ");
				Integer anioEntregaIngresado = TECLADO.nextInt();

				mensajeConsola("\nIngrese el MES DE ENTREGA: ");
				Integer mesEntregaIngresado = TECLADO.nextInt();

				mensajeConsola("\nIngrese el DÍA DE ENTREGA: ");
				Integer diaEntregaIngresado = TECLADO.nextInt();

				LocalDate fechaEntrega3 = LocalDate.of(anioEntregaIngresado, mesEntregaIngresado, diaEntregaIngresado);

				if (profesorEncontrado == null) {
					mensajeConsola("\nError, no se ha podido encontrar el profesor.");
					break;
				}

				if (cursoEncontrado2 == null) {
					mensajeConsola("\nError, no se ha encontrado un curso.");
					break;
				}

				TrabajoPractico trabajoPractico3 = new TrabajoPractico(fechaEntrega3, cursoEncontrado2);
				profesorEncontrado.asignarTrabajoPracticoACurso(trabajoPractico3, cursoEncontrado2);
				mensajeConsola("\nTrabajo práctico asignado.");
				
				break;

			case ENTREGAR_TRABAJO_PRACTICO:
				entregarTrabajoPractico(sistema);
				break;
                
			case SALIR:
				mensajeConsola("\nHas salido del sistema.");
				break;

			default:
				mensajeConsola("\nError, ingrese una opción válida.");
				break;
			}

		} while (!opcionIngresada.equals(Opciones.SALIR));
	}
	
	private static void entregarTrabajoPractico(Sistema sistema) {
		mensajeConsola("\nENTREGAR TRABAJO PRACTICO.");
		mensajeConsola("Ingrese el DNI del alumno: ");
		Integer dniAlumnoIngresado = TECLADO.nextInt();
		
		mensajeConsola("\nIngrese el ID del curso:");
		Integer idCursoIngresado1 = TECLADO.nextInt();
		
		mensajeConsola("\nFechas de entrega: ");
		mensajeConsola("Ingrese el AÑO DE ENTREGA: ");
		Integer anioEntregaIngresado = TECLADO.nextInt();
		
		mensajeConsola("\nIngrese el MES DE ENTREGA: ");
		Integer mesEntregaIngresado = TECLADO.nextInt();
		
		mensajeConsola("\nIngrese el DÍA DE ENTREGA: ");
		Integer diaEntregaIngresado = TECLADO.nextInt();
		
		LocalDate fechaEntrega2 = LocalDate.of(anioEntregaIngresado, mesEntregaIngresado, diaEntregaIngresado);
		
		Alumno alumnoEncontrado = null;
		for (Alumno alumno : sistema.getAlumnos()) {
			if (alumno.getDni().equals(dniAlumnoIngresado)) {
				alumnoEncontrado = alumno;
				break;
			}
		}
		
		Curso cursoEncontrado = null;
		for (Curso curso : sistema.getCursos()) {
			if (curso.getIdCurso().equals(idCursoIngresado1)) {
				cursoEncontrado = curso;
				break;
			}
		}
		
		if (alumnoEncontrado != null && cursoEncontrado != null) {
			for (TrabajoPractico trabajoPractico : alumnoEncontrado.getTrabajosPracticos()) {
				if (trabajoPractico.getCursoAlQuePertenece().equals(cursoEncontrado)) {
					if (alumnoEncontrado.entregarTrabajoPractico(trabajoPractico, fechaEntrega2) == true) {
						mensajeConsola("\nTrabajo practico entregado. ");
					} else {
						mensajeConsola("\nTrabajo practico no entregado.");
					}

					break;
				}
			}
		}

		mensajeConsola("\nError.");
	}

	private static void agregarCurso(Sistema sistema) {
		mensajeConsola("\nAGREGAR CURSO.");
		mensajeConsola("Ingrese el id del curso: ");
		Integer idCursoIngresado2 = TECLADO.nextInt();
		
		mensajeConsola("\nIngrese el nombre del curso: ");
		String nombreCursoIngresado = TECLADO.next();
		
		mensajeConsola("\nIngrese la capacidad máxima de alumnos: ");
		Integer capacidadMaximaIngresado = TECLADO.nextInt();
		
		mensajeConsola("\nIngrese el lenguaje del curso: ");
		String lenguajeCursoIngresado = TECLADO.next();
		
		Curso curso = new CursoProgramacion(idCursoIngresado2, nombreCursoIngresado, capacidadMaximaIngresado, lenguajeCursoIngresado);
		
		sistema.agregarCurso(curso);
		
		mensajeConsola("\nCurso agregado.");
	}

	private static void agregarProfesor(Sistema sistema) {
		mensajeConsola("\nAGREGAR PROFESOR.");
		mensajeConsola("Ingrese el DNI del profesor: ");
		Integer dniProfesorIngresado1 = TECLADO.nextInt();
		
		mensajeConsola("\nIngrese el nombre del profesor: ");
		String nombreProfesorIngresado = TECLADO.next();
		
		mensajeConsola("\nIngrese el apellido del profesor: ");
		String apellidoProfesorIngresado = TECLADO.next();
		
		Profesor profesorCreado = new Profesor(dniProfesorIngresado1, nombreProfesorIngresado, apellidoProfesorIngresado);
		
		sistema.anadirProfesor(profesorCreado);
		
		mensajeConsola("\nProfesor agregado.");
	}

	private static void agregarAlumno(Sistema sistema) {
		mensajeConsola("\nAGREGAR ALUMNO.");
		mensajeConsola("Ingrese el DNI del alumno: ");
		Integer dniAlumnoIngresado1 = TECLADO.nextInt();
		
		mensajeConsola("\nIngrese el nombre del alumno: ");
		String nombreAlumnoIngresado = TECLADO.next();
		
		mensajeConsola("\nIngrese el apellido del alumno: ");
		String apellidoAlumnoIngresado = TECLADO.next();
		
		Alumno alumnoCreado = new Alumno(dniAlumnoIngresado1, nombreAlumnoIngresado, apellidoAlumnoIngresado);
		sistema.anadirAlumno(alumnoCreado);
		
		mensajeConsola("\nAlumno agregado.");
	}

	private static Opciones ingresarOpcionMenuPrincipal() {
		
		mensajeConsola(Opciones.obtenerMenuPrincipal());

		Integer numeroIngresado = 0;
		do {
			numeroIngresado = ingresarEnteroConsola("\nIngrese una opción del menú principal: ");
		} while (numeroIngresado < 0 || numeroIngresado > Opciones.values().length);

		return Opciones.obtenerOpcionDelMenuPrincipal(numeroIngresado);
	}

	private static Integer ingresarEnteroConsola(String mensaje) {
		mensajeConsola(mensaje);

		return TECLADO.nextInt();
	}

	private static void mensajeConsola(String mensaje) {
		System.out.println(mensaje);
	}
}