package icc.be.poo.index;

import java.time.LocalDate;

public class Testappli {
	public static void main(String[] args) {
		Artiste william = new Artiste("ninho");
		Artiste karim = new Artiste("rimk",false);
				
		System.out.println(william);
		System.out.println(karim);
	}
}
