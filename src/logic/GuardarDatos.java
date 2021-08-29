package logic;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import data.Contacto;
import UI.VentanaPrincipal;
import data.Contacto;
import logic.CargarDatos;


public class GuardarDatos {
	
	public static void escribir(ArrayList<Contacto> cargaContactos) {
		String ruta = "Contacto.obj";

		try(ObjectOutputStream outStr = new ObjectOutputStream(new FileOutputStream(ruta))){

			// --> Falta arreglar para mostrar los contactos ya guardados en el archivo Contacto.obj
			ArrayList<Contacto> listaGuardada = CargarDatos.Leer();
			for (Contacto contactoGuardado : listaGuardada){
				outStr.writeObject(contactoGuardado);
			}
			//-->

			for (Contacto contactoIn : cargaContactos){
				outStr.writeObject(contactoIn);
			}

			outStr.close();

		}catch(IOException ex){
			System.out.println(ex.getMessage());
		}
	}
	

}
