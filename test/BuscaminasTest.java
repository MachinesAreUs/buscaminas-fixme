import org.junit.Test;
import static org.junit.Assert.*;

import com.coppel.buscaminas.Parser;
import com.coppel.buscaminas.BuscaMinas;

public class BuscaminasTest {
	
	@Test
	public void resolverBuscaminasSencillo() throws Exception {
		// inicialización
		String tableroStr =
				"4 4\n" +
				"*...\n" +
				"....\n" +
				".*..\n" +
				"....\n";
		BuscaMinas juego = Parser.parse(tableroStr);
		
		// ejecución
		juego.completarTablero();

		// validaciones
		String tableroEsperado = 
				"*100\n" +
				"2210\n" +
				"1*10\n" +
				"1110\n";
		
		assertEquals(tableroEsperado, juego.toString());
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
		BuscaMinas juego = Parser.parse(tableroStr);
		
		// ejecución
		juego.completarTablero();

		// validaciones
		String tableroEsperado = 
				"*1011\n" +
				"2211*\n" +
				"1*111\n" +
				"11100\n";
		
		assertEquals(tableroEsperado, juego.toString());
	}
}
