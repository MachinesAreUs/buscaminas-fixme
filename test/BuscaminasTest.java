import org.junit.Test;
import static org.junit.Assert.*;

import com.coppel.buscaminas.Tablero;

public class BuscaminasTest {

	@Test
	public void inicializaTablero() {
		// inicialización
		Tablero tablero = new Tablero();
		
		// ejecución
		tablero.inicializar(4, 4);

		// validaciones
		String tableroEsperado = 
				"0000\n" +
				"0000\n" +
				"0000\n" +
				"0000\n";
		
		assertEquals(tableroEsperado, tablero.toString());
	}
	
	@Test
	public void agregarCeldas() {
		// inicialización
		Tablero tablero = new Tablero();
		tablero.inicializar(4, 4);
		
		// ejecución
		tablero.agregarFila(0, "*...");
		tablero.agregarFila(1, "....");
		tablero.agregarFila(2, ".*..");
		tablero.agregarFila(3, "....");

		String tableroEsperado = 
				"*000\n" +
				"0000\n" +
				"0*00\n" +
				"0000\n";
		
		assertEquals(tableroEsperado, tablero.toString());
	}
	
	@Test
	public void resolverBuscaminasSencillo() throws Exception {
		// inicialización
		Tablero tablero = new Tablero();
		tablero.inicializar(4, 4);
		tablero.agregarFila(0, "*...");
		tablero.agregarFila(1, "....");
		tablero.agregarFila(2, ".*..");
		tablero.agregarFila(3, "....");
		
		// ejecución
		tablero.completarTablero();

		// validaciones
		String tableroEsperado = 
				"*100\n" +
				"2210\n" +
				"1*10\n" +
				"1110\n";
		
		assertEquals(tableroEsperado, tablero.toString());
	}
	
	@Test
	public void resolverBuscaminasIntermedio() throws Exception {
		// inicialización
		Tablero tablero = new Tablero();
		tablero.inicializar(4, 5);
		tablero.agregarFila(0, "*....");
		tablero.agregarFila(1, "....*");
		tablero.agregarFila(2, ".*...");
		tablero.agregarFila(3, ".....");
		
		// ejecución
		tablero.completarTablero();

		// validaciones
		String tableroEsperado = 
				"*1011\n" +
				"2211*\n" +
				"1*111\n" +
				"11100\n";
		
		assertEquals(tableroEsperado, tablero.toString());
	}
}
