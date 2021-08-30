package logic;

import java.util.ArrayList;
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
		GuardarDatos.escribir(agenda.getListaContactos());

	}
	
	public static void modificarContacto(int i){
		vp.modificarContacto(i);
		vp.visibleBoton(1);
	}
	
	public static void modificarContacto1(){
		agenda.modificarContacto(variablesModificar);
		System.out.println("agenda " + agenda);
		GuardarDatos.escribir(agenda.getListaContactos());
	}
	
	public static void definirAgenda() {
		Agenda lista;
		agenda = new Agenda();
		//agenda =  new Agenda();
		//CargarDatos.Leer();
		try {lista = new Agenda(CargarDatos.Leer());
			
		} catch (Exception e) {
			lista = new Agenda();
		}System.out.println("Agenda: ->"+ lista);
		for (Contacto i : lista.getListaContactos()) {
			crearContacto(i.getNombreContacto(),i.getTelefono(),i.getOperadora(),i.getEmail(),i.getPais(),i.getId());
			vp.addcontador();
			
		}
	}
	
	public static void cerrar() {
		System.out.println("bye");
		System.exit(0);
		System.out.println("no i");
	}
	public static void eliminarContacto(int id) {
		agenda.eliminarContacto(id);
		vp.eliminarContactoUI(id);
		GuardarDatos.escribir(agenda.getListaContactos());

	}
	
			
}
