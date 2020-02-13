package agentes;

public final class Jefazo extends Agentes{
	private int aņosMandato;

	public Jefazo(String nombre, int edad, String direccion, double salario, int aņosMandato) {
		super(nombre, edad, direccion, salario);
		this.aņosMandato = aņosMandato;
	}

	public int getAņosMandato() {
		return aņosMandato;
	}

	public void setAņosMandato(int aņosMandato) {
		this.aņosMandato = aņosMandato;
	}

	@Override
	public String toString() {
		return "************************************\n" + super.toString() + "\nAņos de mandato: "
				+ aņosMandato + "\n************************************";
	}
	
}
