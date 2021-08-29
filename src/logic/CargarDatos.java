package logic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.EOFException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.plaf.synth.SynthSplitPaneUI;

import data.Agenda;
import logic.Main;

import data.Contacto;

public class CargarDatos {
    //Funciona, para probar por ahora usar el botón E
    public static void leer(){

        ArrayList<Contacto> contactosLeidos = new ArrayList<Contacto>();

        try(ObjectInputStream inStr = new ObjectInputStream(new FileInputStream("Contacto.obj"))){
        	
            while(true){
                Contacto contactoLeer = (Contacto)inStr.readObject();
                System.out.println("Nombre: " + contactoLeer.getNombreContacto());
                System.out.println("Telefono" + contactoLeer.getTelefono());
                contactosLeidos.add(contactoLeer);
            }



        }catch(ClassNotFoundException cnfEx){
        }catch(FileNotFoundException fnfEx){
        }catch(EOFException eofEx){
        }catch(IOException ioEx){
        }finally{
            Main.agenda.setListaContactos(contactosLeidos);
        }
        
    }



    //-- De prueba nada más
    public static ArrayList<Contacto> Leer(){
        ArrayList<Contacto> contactoLeido = new ArrayList<Contacto>();

        try(ObjectInputStream inStr = new ObjectInputStream(new FileInputStream("Contacto.obj"))){

            while(true){
                Contacto contactoLeer = (Contacto)inStr.readObject();
                System.out.println("Nombre: " + contactoLeer.getNombreContacto());
                System.out.println("Telefono" + contactoLeer.getTelefono());
                contactoLeido.add(contactoLeer);
            }

            

        }catch(ClassNotFoundException cnfEx){
        }catch(FileNotFoundException fnfEx){
        }catch(EOFException eofEx){
        }catch(IOException ioEx){
        }
        return contactoLeido;
        
    }

    //-->
}

