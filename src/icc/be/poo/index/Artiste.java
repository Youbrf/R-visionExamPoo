package icc.be.poo.index;

import java.time.LocalDate;

public class Artiste {
	private String nomArtiste;
	private LocalDate dateCreation;
	private boolean isVip;
	
	public Artiste(String nomArtiste) {
		super();
		this.nomArtiste = nomArtiste;
		this.dateCreation = LocalDate.now().plusDays(3);
		this.isVip = false;
	}
	public Artiste(String nomArtiste,boolean IsVip) {
		super();
		this.nomArtiste = nomArtiste;
		this.dateCreation = LocalDate.now();
		this.isVip = IsVip;
	}

	@Override
	public String toString() {
		return "Artiste \n[Artiste=" + nomArtiste 
				+ "\n, dateCreation=" + dateCreation 
				+ "\n, isVip=" + isVip 
				+ "]";
	}
	
	
	
}
