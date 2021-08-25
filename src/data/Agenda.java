package data;

import java.io.Serializable;
import java.util.ArrayList;

public class Agenda implements Serializable{

	private static final long serialVersionUID = 1L;
	
	ArrayList<Contacto> listaContactos;

	public ArrayList<Contacto> getListaContactos() {
		return listaContactos;
	}

	public void setListaContactos(ArrayList<Contacto> listaContactos) {
		this.listaContactos = listaContactos;
	}

	public Agenda(ArrayList<Contacto> listaContactos) {//constructor para cuando hay una lista traida serializable
		super();
		this.listaContactos = listaContactos;
	}
	public Agenda() {//contructor para lsta desde cero
		super();
		this.listaContactos = new ArrayList<Contacto>();
	}
	
	public void addContacto(Contacto contacto) {
		listaContactos.add(contacto);
	}

}
