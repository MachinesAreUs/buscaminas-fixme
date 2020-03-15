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
				"0000" +
				"0000" +
				"0000" +
				"0000";
		
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
				"*000" +
				"0000" +
				"0*00" +
				"0000";
		
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
				"*100" +
				"2210" +
				"1*10" +
				"1110";
		
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
				"*1011" +
				"2211*" +
				"1*111" +
				"11100";
		
		assertEquals(tableroEsperado, tablero.toString());
	}
}
