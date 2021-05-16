package icc.be.poo.metier;

import icc.be.poo.exception.DuplicateArtistException;
import icc.be.poo.index.Artiste;
import icc.be.poo.index.Concert;

public interface IMetier {
	public void toXmlFile(Concert concert, String fileName);
	public Concert malzak(String fileName);
	public void toJsonFile(Concert concert, String fileName);
	public Concert fromJsonFile(String fileName);
	public boolean dropArtist(Artiste a);
	public boolean hadArtist(Artiste a) throws DuplicateArtistException;
}
