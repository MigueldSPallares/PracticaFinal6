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
		return super.toString() + " \nPisos:" + Arrays.toString(pisos);
	}
	
}
