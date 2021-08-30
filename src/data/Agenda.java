package data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.*;

import logic.Main;

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
	public void modificarContacto(String[] variables) {
		System.out.println(variables[0]+ variables[1]+variables[2]+variables[3]+variables[4]+variables[5]);
		
		listaContactos.get(getContactoPorId(Integer.parseInt(variables[5]))).setNombreContacto(variables[0]);
		listaContactos.get(getContactoPorId(Integer.parseInt(variables[5]))).setTelefono(Integer.parseInt(variables[1]));
		listaContactos.get(getContactoPorId(Integer.parseInt(variables[5]))).setOperadora(variables[2]);
		listaContactos.get(getContactoPorId(Integer.parseInt(variables[5]))).setEmail(variables[3]);
		listaContactos.get(getContactoPorId(Integer.parseInt(variables[5]))).setPais(variables[4]);
		
		Main.vp.actualizarContactoUi(listaContactos.get(getContactoPorId(Integer.parseInt(variables[5]))));
		System.out.println("contact modificado " + getContactoPorId(Integer.parseInt(variables[5])));
	}
	public Integer getContactoPorId(int i) {
		int a=-1;
		for (int p=0; p<listaContactos.size();p++) {
			System.out.println(p);
			if (i==(listaContactos.get(p)).getId()) {
				a=p;
			}
		}
		
		return a;
	}
	
	public void eliminarContacto(int id) {
		int index = getContactoPorId(id);
		listaContactos.remove(index);
	}

	@Override
	public String toString() {
		return "Agenda [listaContactos=" + listaContactos + "]";
	}
	/*public void serializarAgenda() {
		try {
			ObjectOutputStream escribiendo_fichero = new ObjectOutputStream(new FileOutputStream("C:\\Users\\ca22a\\OneDrive\\Email attachments\\Documentos\\ALEJANDRO\\Agenda\\Fichero.txt"));
			
			escribiendo_fichero.writeObject(listaContactos);

			escribiendo_fichero.close();
			
			ObjectInputStream recuperando_fichero = new ObjectInputStream(new FileInputStream("C:\\Users\\ca22a\\OneDrive\\Email attachments\\Documentos\\ALEJANDRO\\Agenda\\Fichero.txt"));
			
			ArrayList<Contacto> listadoContactos  = (ArrayList<Contacto>) recuperando_fichero.readObject();
			
			recuperando_fichero.close();	

		}catch(Exception e) {
			
		}
		
	}*/
	
	
	
}

