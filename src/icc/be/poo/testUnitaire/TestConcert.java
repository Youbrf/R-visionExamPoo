package icc.be.poo.testUnitaire;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import icc.be.poo.index.Artiste;
import icc.be.poo.index.Concert;

class TestConcert {

	@Test
	void testconstruct() {
		Concert con = new Concert("Rock");
		ArrayList<Artiste> art = new ArrayList<>();
		
		Artiste william = new Artiste("ninho");
		Artiste karim = new Artiste("rimk",false);
		
		art.add(karim);
		art.add(karim);
		
		con.getArtistes().add(karim);
		con.getArtistes().add(william);
		
		assertEquals("Rock", con.getDesignation());
		assertEquals(art , con.getArtistes());
//		assertEquals(2,con.getArtistes().size());
		
	}

}
