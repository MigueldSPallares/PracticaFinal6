package main;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class IODatos {
	public final static String ruta = "pisos.txt";
	public final static String ruta2 = "armas.txt";

	public void guardarPiso() {
		File fichero = new File(ruta);
		String piso = "";
		Scanner leer = new Scanner (System.in);
		if (!fichero.exists()) {
			try {
				fichero.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		PrintWriter escribir;
		FileWriter f;
		try {
			f = new FileWriter(fichero, true);
			escribir = new PrintWriter(f);
			System.out.println("Pon el nombre del nuevo piso");
			piso = leer.nextLine();
			escribir.println(piso);
			escribir.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String[] cargarPiso() {
		String[] vPisos = new String[10];
		File fichero = new File(ruta);
		Scanner leer;
		if (!fichero.exists()) {
			try {
				fichero.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			leer = new Scanner(fichero);
			while(leer.hasNextLine()) {
				String piso;
				piso = leer.nextLine();
				for (int i = 0; i < vPisos.length; i++) {
					if (vPisos[i]==null) {
						vPisos[i]=piso;
						break;
					}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vPisos;
	}
	
	public void guardarArma() {
		String arma = "";
		File fichero = new File(ruta2);
		Scanner leer = new Scanner(System.in);
		if (!fichero.exists()) {
			try {
				fichero.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		PrintWriter escribir;
		FileWriter f;
		try {
			f = new FileWriter(fichero, true);
			escribir = new PrintWriter(f);
			System.out.println("Pon el nombre de la nueva arma");
			arma = leer.nextLine();
			escribir.println(arma);
			escribir.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String[] cargarArma() {
		String[] vArmas= new String[10];
		File fichero = new File(ruta2);
		Scanner leer;
		if (!fichero.exists()) {
			try {
				fichero.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			leer = new Scanner(fichero);
			while(leer.hasNextLine()) {
				String arma;
				arma = leer.nextLine();
				for (int i = 0; i < vArmas.length; i++) {
					if (vArmas[i]==null) {
						vArmas[i]=arma;
						break;
					}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vArmas;
	}
	
	public void encriptar() {
		File fichero1 = new File(ruta);
		File fichero2 = new File(ruta2);
		String[] arma = cargarArma();
		String[] piso = cargarPiso();
		if (!fichero1.exists()) {
			try {
				fichero1.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (!fichero2.exists()) {
			try {
				fichero2.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			FileOutputStream fo1 = new FileOutputStream(fichero1);
			DataOutputStream escribir1 = new DataOutputStream(fo1);
			FileOutputStream fo2 = new FileOutputStream(fichero2);
			DataOutputStream escribir2 = new DataOutputStream(fo2);
			for (int i = 0; i < piso.length; i++) {
				if(piso[i]!=null) {
					escribir1.writeUTF(piso[i]);
				}
			}
			for (int i = 0; i < arma.length; i++) {
				if(arma[i]!=null) {
					escribir2.writeUTF(arma[i]);
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
