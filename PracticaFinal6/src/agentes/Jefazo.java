package agentes;

public final class Jefazo extends Agentes{
	private int a�osMandato;

	public Jefazo(String nombre, int edad, String direccion, double salario, int a�osMandato) {
		super(nombre, edad, direccion, salario);
		this.a�osMandato = a�osMandato;
	}

	public int getA�osMandato() {
		return a�osMandato;
	}

	public void setA�osMandato(int a�osMandato) {
		this.a�osMandato = a�osMandato;
	}

	@Override
	public String toString() {
		return "************************************\n" + super.toString() + "\nA�os de mandato: "
				+ a�osMandato + "\n************************************";
	}
	
}
