import org.junit.Test;
import static org.junit.Assert.*;

import com.coppel.buscaminas.Parser;
import com.coppel.buscaminas.Tablero;

public class BuscaminasTest {

	@Test
	public void inicializaTablero() {
		// inicialización
		Tablero tablero = new Tablero(4, 4);

		// validaciones
		String tableroEsperado = 
				"0000\n" +
				"0000\n" +
				"0000\n" +
				"0000\n";
		
		assertEquals(tableroEsperado, tablero.toString());
	}
	
	@Test
	public void resolverBuscaminasSencillo() throws Exception {
		// inicialización
		String tableroStr =
				"4 4\n" +
				"*...\n" +
				"....\n" +
				".*..\n" +
				"....\n";
		Tablero tablero = Parser.parse(tableroStr);
		
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
		String tableroStr =
				"4 5\n" +
				"*....\n" +
				"....*\n" +
				".*..;\n" +
				".....\n";
		Tablero tablero = Parser.parse(tableroStr);
		
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
