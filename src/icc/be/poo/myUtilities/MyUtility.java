package icc.be.poo.myUtilities;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.io.xml.DomDriver;

import icc.be.poo.index.Artiste;
import icc.be.poo.index.Concert;

public class MyUtility {
	// XML 
	private static XStream xs = new XStream(new DomDriver());
	// Serialisation
	public static void toXmlFile(Concert concert, String fileName) {
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
	// Deserialisation
	public static Concert fromXmlFile(String fileName) {
		xs.alias("Concert", Concert.class);
		xs.alias("Artiste",Artiste.class);
		xs.useAttributeFor(Artiste.class,"dateCreation");
		xs.addImplicitCollection(Concert.class, "artistes");
		
		return (Concert) xs.fromXML(new File(fileName));
	}
	// Json
	private static XStream xsJson = new XStream(new JsonHierarchicalStreamDriver());
	private static XStream xsJson1 = new XStream(new JettisonMappedXmlDriver());
	// Sérialisation
	public static void toJsonFile(Concert concert, String fileName) {
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
	// Déserialisation
	public static Concert fromJsonFile(String fileName) {
		xsJson1.alias("Concert", Concert.class);
		xsJson1.alias("Artiste",Artiste.class);
		xsJson1.addImplicitCollection(Concert.class, "artistes");
		return (Concert) xsJson1.fromXML(new File(fileName));
	}
	
}
