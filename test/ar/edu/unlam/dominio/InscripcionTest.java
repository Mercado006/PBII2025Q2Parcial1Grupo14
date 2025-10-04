package ar.edu.unlam.dominio;

public class InscripcionTest {
	
	@Test
	public void dadoQueExisteUnaInscripcionConUnaListaDeNotasElMetodoCalcularPromedioDevuelveLaDivisionEntreLasNotasYElSizeDeDichaLista() {
		Integer notaUno = 7;
		Integer notaDos = 8;
		
		Inscripcion inscripcion = new Inscripcion();
		
		inscripcion.agregarNota(notaUno);
		inscripcion.agregarNota(notaDos);
		
		Double promedioEsperado = 7.5;
		Double promedioObtenido = inscripcion.calcularPromedio();
	}
	
	@Test
	public void dadoQueExisteUnaInscripcionConUnaListaDeNotasElMetodoAgregarNotaAgregaLaNotaADichaLista() {
		Integer nota = 7;
		
		Inscripcion inscripcion = new Inscripcion();
		
		inscripcion.agregarNota(nota);
		
		Integer tamañoEsperado = 1;
		Integer tamañoObtenido = inscripcion.getNotas().size();
		
		assertEquals(tamañoEsperado, tamañoObtenido);
	}

}
