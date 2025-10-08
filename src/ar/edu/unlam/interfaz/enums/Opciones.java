package ar.edu.unlam.interfaz.enums;

public enum Opciones {

	AGREGAR_ALUMNO("Agregar un alumno."),
	AGREGAR_PROFESOR("Agregar un profesor."),
	AGREGAR_CURSO("Agregar un curso."),
	ASIGNAR_TRABAJO_PRACTICO("Asignar trabajo practico."),
	ENTREGAR_TRABAJO_PRACTICO("Entregar trabajo practico."),
	SALIR("Salir.");

	private String descripcion;

	private Opciones(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public static String obtenerMenuPrincipal() {
		String menuPrincipal = "\nMenú principal. ";

		Opciones[] opciones = Opciones.values();

		for (int i = 0; i < opciones.length; i++) {
			menuPrincipal += "\n" + (i + 1) + ". " + opciones[i].getDescripcion();
		}

		return menuPrincipal;
	}

	public static Opciones obtenerOpcionDelMenuPrincipal(Integer opcionIngresada) {
		return Opciones.values()[opcionIngresada - 1];
	}
}