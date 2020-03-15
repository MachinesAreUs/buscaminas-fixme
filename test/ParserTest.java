import static org.junit.Assert.*;

import org.junit.Test;

import com.coppel.buscaminas.Parser;
import com.coppel.buscaminas.Celda;

public class ParserTest {

	@Test
	public void parsearFilaSinMinas() {
		Celda[] fila = Parser.parsearFila("....");
		
		assertEquals(4, fila.length);
		
		for (Celda celda : fila) {
			assertFalse(celda.isMina());
		}
	}
	
	@Test
	public void parsearFilaConTodasMinas() {
		Celda[] fila = Parser.parsearFila("****");
		
		assertEquals(4, fila.length);
		
		for (Celda celda : fila) {
			assertTrue(celda.isMina());
		}
	}
	
	@Test
	public void parsearFilaConMinasIntercaladas() {
		Celda[] fila = Parser.parsearFila("*.*.");
		
		assertEquals(4, fila.length);
		
		assertTrue(fila[0].isMina());
		assertFalse(fila[1].isMina());
		assertTrue(fila[2].isMina());
		assertFalse(fila[3].isMina());
	}

}
