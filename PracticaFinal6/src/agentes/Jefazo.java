package agentes;

public final class Jefazo extends Agentes{
	private int añosMandato;

	public Jefazo(String nombre, int edad, String direccion, double salario, int añosMandato) {
		super(nombre, edad, direccion, salario);
		this.añosMandato = añosMandato;
	}

	public int getAñosMandato() {
		return añosMandato;
	}

	public void setAñosMandato(int añosMandato) {
		this.añosMandato = añosMandato;
	}

	@Override
	public String toString() {
		return "************************************\n" + super.toString() + "\nAños de mandato: "
				+ añosMandato + "\n************************************";
	}
	
}
