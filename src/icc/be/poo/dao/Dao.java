package icc.be.poo.dao;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.io.xml.DomDriver;

import icc.be.poo.exception.DuplicateArtistException;
import icc.be.poo.index.Artiste;
import icc.be.poo.index.Concert;

public class Dao implements IDao {

	private static XStream xs = new XStream(new DomDriver());
	private static XStream xsJson = new XStream(new JsonHierarchicalStreamDriver());
	private static XStream xsJson1 = new XStream(new JettisonMappedXmlDriver());
	Concert DogCoin = new Concert();
	
	
	public Dao() {
		super();
		DogCoin.setArtistes(new ArrayList<>());
		DogCoin.setDesignation("Rock");
		DogCoin.getArtistes().add(new Artiste("jul", false));
		DogCoin.getArtistes().add(new Artiste("rimk", false));
		DogCoin.getArtistes().add(new Artiste("ninho",true));
			
	}

	@Override
	public void toXmlFile(Concert concert, String fileName) {
		xs.alias("Concert", Concert.class);
		xs.alias("Artiste",Artiste.class);
		xs.useAttributeFor(Artiste.class,"dateCreation");
		xs.addImplicitCollection(Concert.class, "artistes");
		try {
			xs.toXML(concert,new FileWriter(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Concert fromXmlFile(String fileName) {
		xs.alias("Concert", Concert.class);
		xs.alias("Artiste",Artiste.class);
		xs.useAttributeFor(Artiste.class,"dateCreation");
		xs.addImplicitCollection(Concert.class, "artistes");
		
		return (Concert) xs.fromXML(new File(fileName));
	}

	@Override
	public void toJsonFile(Concert concert, String fileName) {
		xsJson.alias("Concert", Concert.class);
		xsJson.alias("Artiste",Artiste.class);
		xsJson.useAttributeFor(Artiste.class,"dateCreation");
		xsJson.addImplicitCollection(Concert.class, "artistes");
		try {
			xsJson.toXML(concert,new FileWriter(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Concert fromJsonFile(String fileName) {
		xsJson1.alias("Concert", Concert.class);
		xsJson1.alias("Artiste",Artiste.class);
		xsJson1.addImplicitCollection(Concert.class, "artistes");
		return (Concert) xsJson1.fromXML(new File(fileName));
	}

	@Override
	public boolean dropArtist(Artiste a) {
		for (Artiste artiste : DogCoin.getArtistes()) {
			if(artiste.equals(a)) {
				DogCoin.getArtistes().remove(a);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean hadArtist(Artiste a) throws DuplicateArtistException {
		for (Artiste artiste : DogCoin.getArtistes()) {
			if(artiste.equals(a)) {
				throw new DuplicateArtistException("Cette artiste est déjà dans la liste");
			}
		}
		DogCoin.getArtistes().add(a);
		return true;
	}

}
