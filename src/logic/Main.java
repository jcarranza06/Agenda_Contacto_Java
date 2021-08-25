package logic;

import java.util.Iterator;

import UI.ContactoUI;
import UI.VentanaPrincipal;
import data.Contacto;

public class Main {

	public static void main(String[] args) {
		VentanaPrincipal vp= new VentanaPrincipal();
		vp.setVisible(true);
		
		
		Contacto[] contactos = new Contacto[50];
		for (int i =0;i<49;i++) {
			contactos[i]=new Contacto("juan", 315, "wom", "juan@cumama.com", "colombia");
			
		}
		
		

	}

}
