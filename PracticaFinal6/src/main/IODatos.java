package main;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

import agentes.Agentes;

public class IODatos {
	public final static String ruta = "datos/pisos.txt";
	public final static String ruta2 = "datos/armas.txt";

	public void guardarPiso() {
		File fichero = new File(ruta);
		String piso = "";
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
		Scanner leer = null;
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
			while (leer.hasNextLine()) {
				String piso;
				piso = leer.nextLine();
				for (int i = 0; i < vPisos.length; i++) {
					if (vPisos[i] == null) {
						vPisos[i] = piso;
						break;
					}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			leer.close();
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
		String[] vArmas = new String[10];
		File fichero = new File(ruta2);
		Scanner leer = null;
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
			while (leer.hasNextLine()) {
				String arma;
				arma = leer.nextLine();
				for (int i = 0; i < vArmas.length; i++) {
					if (vArmas[i] == null) {
						vArmas[i] = arma;
						break;
					}
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			leer.close();
		}
		return vArmas;
	}

	public void encriptar(Agentes[] vAgentes) {
		File fichero1 = new File("datos/PisosEncriptado.txt");
		File fichero2 = new File("datos/ArmasEncriptado.txt");
		File fichero3 = new File("datos/Agentes.txt");
		File fic1 = new File(ruta);
		File fic2 = new File(ruta2);
		String[] arma = cargarArma();
		String[] piso = cargarPiso();
		if (fic1.delete()) {
			System.out.println("Se ha borrado el fichero");
		}
		if (fic2.delete()) {
			System.out.println("Se ha borrado el fichero");
		}
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
		if (!fichero3.exists()) {
			try {
				fichero3.createNewFile();
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
			FileOutputStream fo3 = new FileOutputStream(fichero3);
			ObjectOutputStream escribir3 = new ObjectOutputStream(fo3);
			for (int i = 0; i < piso.length; i++) {
				if (piso[i] != null) {
					escribir1.writeUTF(piso[i]);
				}
			}
			escribir1.close();
			for (int i = 0; i < arma.length; i++) {
				if (arma[i] != null) {
					escribir2.writeUTF(arma[i]);
				}
			}
			escribir2.close();
			for (Agentes agente : vAgentes) {
				if (agente != null) {
					escribir3.writeObject(agente);
				}
			}
			escribir3.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void desencriptar(Agentes[] vAgentes) {
		File fic1 = new File("datos/ArmasEncriptado.txt");
		File fic2 = new File("datos/PisosEncriptado.txt");
		File fic3 = new File("datos/Agentes.txt");
		File fichero1 = new File(ruta2);
		File fichero2 = new File(ruta);
		if (fic3.delete()) {
			System.out.println("Se ha borrado el fichero");
		}
		String[] piso = new String[10];
		String[] arma = new String[10];
		FileInputStream f1 = null;
		DataInputStream leer1 = null;
		FileInputStream f2 = null;
		DataInputStream leer2 = null;
		FileWriter fi1 = null;
		PrintWriter escribir1 = null;
		FileWriter fi2 = null;
		PrintWriter escribir2 = null;
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
			f1 = new FileInputStream(fic1);
			leer1 = new DataInputStream(f1);
			while (true) {
				for (int i = 0; i < arma.length; i++) {
					if (arma[i] == null) {
						arma[i] = leer1.readUTF();
						break;
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Fin de lectura de armas");
		} finally {
			try {
				leer1.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			f2 = new FileInputStream(fic2);
			leer2 = new DataInputStream(f2);
			while (true) {
				for (int i = 0; i < piso.length; i++) {
					if (piso[i] == null) {
						piso[i] = leer2.readUTF();
						break;
					}
				}
			}
		} catch (Exception e) {
			System.out.println("Fin de lectura de pisos");
		} finally {
			try {
				leer2.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			fi1 = new FileWriter(fichero1, true);
			escribir1 = new PrintWriter(fi1);
			for (int i = 0; i < arma.length; i++) {
				if (arma[i] != null) {
					escribir1.println(arma[i]);
				}
			}
		} catch (IOException e) {
			System.out.println("Fin de la lectura");
		}finally {
			escribir1.close();
			fic1.delete();
		}
		try {
			fi2 = new FileWriter(fichero2, true);
			escribir2 = new PrintWriter(fi2);
			for (int i = 0; i < piso.length; i++) {
				if (piso[i] != null) {
					escribir2.println(piso[i]);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Fin de la lectura");
		}finally {
			escribir2.close();
			fic2.delete();
		}
	}
}
