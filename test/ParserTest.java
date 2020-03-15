import static org.junit.Assert.*;

import org.junit.Test;

import com.coppel.buscaminas.Parser;
import com.coppel.buscaminas.Celda;
import com.coppel.buscaminas.Dimensiones;

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
	
	@Test
	public void parsearEncabezado() {
		Dimensiones dim = Parser.parseaEncabezados("10 20");
	
		assertEquals(10, dim.filas);
		assertEquals(20, dim.columnas);
	}
}
