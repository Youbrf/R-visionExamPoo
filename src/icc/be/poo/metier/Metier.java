package icc.be.poo.metier;

import icc.be.poo.dao.*;
import icc.be.poo.exception.DuplicateArtistException;
import icc.be.poo.index.Artiste;
import icc.be.poo.index.Concert;

public class Metier implements IMetier {
	IDao dao = new Dao();
	
	@Override
	public void toXmlFile(Concert concert, String fileName) {
		dao.toXmlFile(concert, fileName);
	}

	@Override
	public Concert malzak(String fileName) {
		return dao.fromXmlFile(fileName);
	}

	@Override
	public void toJsonFile(Concert concert, String fileName) {
		dao.toJsonFile(concert, fileName);
	}

	@Override
	public Concert fromJsonFile(String fileName) {
		return dao.fromJsonFile(fileName);
	}

	@Override
	public boolean dropArtist(Artiste a) {
		return dao.dropArtist(a);
	}

	@Override
	public boolean hadArtist(Artiste a) throws DuplicateArtistException {
		return dao.hadArtist(a);
	}

}
