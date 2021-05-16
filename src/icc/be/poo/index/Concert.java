package icc.be.poo.index;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeSet;

import icc.be.poo.exception.DuplicateArtistException;

public class Concert extends Evenement implements Serializable {
	private String designation;
	private ArrayList<Artiste> artistes;
	

	public Concert() {
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

	public ArrayList<Artiste> getVIPs() {
		ArrayList<Artiste> result = new ArrayList<>();
		for (Artiste artiste : artistes) {
			if(artiste.isVip()) {
				result.add(artiste);
			}
		}
		return result;
	}

	@Override
	public String toString() {
		return "Concert [\ndesignation=" + designation 
				+ ", \nartistes=\n" + artistes + "]";
	}
	
}
