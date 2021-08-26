package logic;

import java.util.Iterator;

import UI.ContactoUI;
import UI.VentanaPrincipal;
import data.Agenda;
import data.Contacto;

public class Main {
	static Agenda agenda;

	public static void main(String[] args) {
		VentanaPrincipal vp= new VentanaPrincipal();
		vp.setVisible(true);
		definirAgenda();
		
		
		
		//Contacto[] contactos = new Contacto[50];
		
		
		for (int i =0;i<49;i++) {
			agenda.addContacto(new Contacto("juan", 315, "wom", "juan@cumama.com", "colombia")); 
			
		}
		
	} 
	public static void crearContacto(String nombre, int numero, String operadora, String email, String pais){
		agenda.addContacto(new Contacto(nombre, numero, operadora, email, pais)); 

		
	}
	public static void definirAgenda() {
		agenda =  new Agenda();
	}
	
			
}
