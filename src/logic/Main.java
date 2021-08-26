package logic;

import java.util.Iterator;

import UI.ContactoUI;
import UI.VentanaPrincipal;
import data.Agenda;
import data.Contacto;

public class Main {
	public static Agenda agenda;
	public static VentanaPrincipal vp;
	static String[] variablesModificar=new String[6];
	
	public String[] getVariablesModificar() {
		return variablesModificar;
	}
	public static void setVariablesModificar(String[] variablesModificare) {
		variablesModificar = variablesModificare;
	}
	public static void main(String[] args) {
		vp= new VentanaPrincipal();
		vp.setVisible(true);
		definirAgenda();
		
		/*for (int i =0;i<49;i++) {
			agenda.addContacto(new Contacto("juan", 315, "wom", "juan@cumama.com", "colombia",1)); 
			
		}*/
		
	} 
	public static void crearContacto(String nombre, int numero, String operadora, String email, String pais, int id){
		agenda.addContacto(new Contacto(nombre, numero, operadora, email, pais, id)); 
	}
	
	public static void modificarContacto(int i){
		vp.modificarContacto(i);
		vp.visibleBoton(1);
	}
	
	public static void modificarContacto1(){
		agenda.modificarContacto(variablesModificar);
		System.out.println("agenda " + agenda);
		
	}
	
	public static void definirAgenda() {
		agenda =  new Agenda();
	}
	
	public static void cerrar() {
		System.out.println("bye");
		System.exit(0);
		System.out.println("no i");
	}
	
			
}
