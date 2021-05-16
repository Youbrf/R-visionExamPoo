package icc.be.poo.testUnitaire;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import icc.be.poo.exception.DuplicateArtistException;
import icc.be.poo.index.Artiste;
import icc.be.poo.index.Concert;

class TestConcert {
	Concert con = new Concert("Rock");
	
	@Test
	public void testGetVips() {
		ArrayList<Artiste> art = new ArrayList<>();
		Artiste william = new Artiste("ninho",true);
		Artiste karim = new Artiste("rimk", false);
		Artiste julien = new Artiste("jul", false);
		art.add(william);
		
		con.getArtistes().add(julien);
		con.getArtistes().add(william);
		con.getArtistes().add(karim);
			
		assertEquals(art, con.getVIPs());
		
	}
	
	@Test
	public void testDropArtistFalse() {
		Artiste william = new Artiste("ninho");
		Artiste karim = new Artiste("rimk", false);
		con.hadArtist(karim);
		
		assertEquals(false, con.dropArtist(william));
	}
	
	@Test
	public void testDropArtistTrue() {
		Artiste karim = new Artiste("rimk", false);
		con.hadArtist(karim);
		
		assertEquals(true, con.dropArtist(karim));
	}
	
	@Test
	public void testToString() {
		String result = "Designation = Rock";
		assertEquals(result, con.toString());
	}
	
	@Test
	public void testconstruct() {
		Artiste william = new Artiste("ninho");
		Artiste karim = new Artiste("rimk", false);
		
		ArrayList<Artiste> art = new ArrayList<>();
		art.add(karim);
		art.add(william);
		
		con.getArtistes().add(karim);
		con.getArtistes().add(william);

		assertEquals("Rock", con.getDesignation());
		assertEquals(art, con.getArtistes());
//		assertEquals(2,con.getArtistes().size());

	}

	@Test
	public void testHadArtist() {
		Artiste william = new Artiste("ninho");
		Artiste karim = new Artiste("rimk", false);
		Artiste julien = new Artiste("jul", false);

		con.getArtistes().add(karim);
		con.getArtistes().add(william);
		
		assertEquals(true, con.hadArtist(julien));

	}
	
	@Test
	public void testHadArtistBis() {
		ArrayList<Artiste> listeArtiste = new ArrayList<>();
		Artiste william = new Artiste("ninho");
		Artiste karim = new Artiste("rimk", false);
		Artiste julien = new Artiste("jul", false);
		
		listeArtiste.add(karim);
		listeArtiste.add(william);
		listeArtiste.add(julien);
		
		con.getArtistes().add(karim);
		con.getArtistes().add(william);
		
		con.hadArtist(julien);
		
		assertEquals(listeArtiste.size(), con.getArtistes().size());

	}
	
	@Test
	public void testHadArtist1() {
		Artiste william = new Artiste("ninho");
		Artiste karim = new Artiste("rimk", false);

		con.getArtistes().add(karim);
		con.getArtistes().add(william);
		
		assertThrows(DuplicateArtistException.class, () -> {
			con.hadArtist(karim);
		});
	}

}
