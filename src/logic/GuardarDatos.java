package logic;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import data.Contacto;
import UI.VentanaPrincipal;
import data.Contacto;


public class GuardarDatos {


	public static void escribir(Contacto contactoIn) {
		String ruta = "Contacto.obj";

		try(ObjectOutputStream outStr = new ObjectOutputStream(new FileOutputStream(ruta))){
			outStr.writeObject(contactoIn);
			outStr.close();
		}catch(IOException ex){
			System.out.println(ex.getMessage());
		}
	}

	public static void ejecutar(ArrayList<Contacto> listaContactos){
		for (Contacto contacto : listaContactos){
			GuardarDatos.escribir(contacto);
		}
	}

	
	

}
