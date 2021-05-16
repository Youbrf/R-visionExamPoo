package icc.be.poo.ui;

import icc.be.poo.index.Concert;
import icc.be.poo.metier.*;

public class UiConsole implements IUi {

	@Override
	public void run() {
		IMetier metier = new Metier(); 
		
		System.out.println(metier);
		

	}

}
