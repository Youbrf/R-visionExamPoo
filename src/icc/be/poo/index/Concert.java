package icc.be.poo.index;

import java.util.ArrayList;

public class  Concert extends Evenement implements Manageable{
	private String designation;
	private ArrayList<Artiste> artistes;
	

	public Concert(String designation) {
		super();
		this.designation = designation;
		this.artistes = new ArrayList<>();
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public ArrayList<Artiste> getArtistes() {
		return artistes;
	}

	public void setArtistes(ArrayList<Artiste> artistes) {
		this.artistes = artistes;
	}

	public void getVIPs() {
		
	}

	@Override
	public boolean dropArtist(Artiste a) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hadArtist(Artiste a) {
		// TODO Auto-generated method stub
		return false;
	}
}
