package agentes;

import java.util.Arrays;

import main.IODatos;

public final class Espionaje extends Agentes{
	private String[] pisos;
	
	
	public Espionaje(String nombre, int edad, String direccion, double salario) {
		super(nombre, edad, direccion, salario);
		IODatos iodatos = new IODatos();
		this.pisos = iodatos.cargarPiso();
	}
	@Override
	public String toString() {
		String vPisos= "";
		for (String p : pisos) {
			if(p!=null) {
				vPisos += p + ", ";
			}
		}
		return super.toString() + " \nPisos:" + vPisos;
	}
	
}
