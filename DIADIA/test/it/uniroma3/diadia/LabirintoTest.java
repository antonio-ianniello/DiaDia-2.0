package it.uniroma3.diadia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

public class LabirintoTest {
	private Labirinto universit√;
	private Stanza stanzaTest;

	@Before
	public void setUp() throws Exception {
		universit√= new Labirinto("Labirinto.txt");
		stanzaTest= new Stanza("StanzaTest");
	}

	@Test
	public void testGetStanzaCorrenteDefault() {
		assertEquals("atrio", universit√.getStanzaCorrente().getNome());
	}
	
	@Test
	public void testGetStanzaCorrente() {
		universit√.setStanzaCorrente(stanzaTest);
		assertEquals("StanzaTest", universit√.getStanzaCorrente().getNome());
	}
	
	@Test
	public void testSetStanzaCorrenteDefault() {
		assertEquals("atrio", universit√.getStanzaCorrente().getNome());
	}

	@Test
	public void testSetStanzaCorrente() {
		universit√.setStanzaCorrente(stanzaTest);
		assertEquals("StanzaTest", universit√.getStanzaCorrente().getNome());
	}

	@Test
	public void testGetStanzaVincente() {
		assertEquals("biblioteca", universit√.getStanzaVincente().getNome());
	}

}
