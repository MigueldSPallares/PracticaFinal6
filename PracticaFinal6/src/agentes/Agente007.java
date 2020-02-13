package agentes;

import java.util.Arrays;

import main.IODatos;

public final class Agente007 extends Agentes{
	private int numMuertos;
	private String[] armas;
	public Agente007(String nombre, int edad, String direccion, double salario, int numMuertos) {
		super(nombre, edad, direccion, salario);
		this.numMuertos = numMuertos;
		IODatos IODatos = new IODatos();
		this.armas = IODatos.cargarArma();
	}
	@Override
	public String toString() {
		return super.toString() + "\nnumMuertos: " + numMuertos + "\narmas=" + Arrays.toString(armas);
	}
	
}
