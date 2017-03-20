package br.com.stream;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class AppTest {
	
	@Test
	public void testaVogalEcnontrada() {
		Stream stream = new StreamImpl();
		stream.setInput("aAbBABacafe");
		char vogal = App.firstChar(stream);
		System.out.println("Vogal única: " + vogal);
		assertNotNull(vogal);
	}
	
	@Test
	public void testaResultaNaoEncontrado() {
		Stream stream = new StreamImpl();
		stream.setInput("aAbBABacafoe");
		char vogal = App.firstChar(stream);
		System.out.println("Vogal única: " + vogal);
		assertNull(vogal);
	}
	
	@Test
	public void testaMaisDeUmResultado() {
		Stream stream = new StreamImpl();
		stream.setInput("aAbBABacafeGu");
		char vogal = App.firstChar(stream);
		System.out.println("Vogal única: " + vogal);
		assertNotNull(vogal);
	}
}
