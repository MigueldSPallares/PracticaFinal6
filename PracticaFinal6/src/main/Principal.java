package main;

import java.util.Scanner;

import agentes.Agentes;
import agentes.Jefazo;

public class Principal {
	
	public static void salarioMayorQue(Agentes[] vAgente) {
		Scanner leer = new Scanner(System.in);
		double valor;
		System.out.println("Pon un número y te mostraré los agentes que ganan más que ese valor");
		valor = leer.nextDouble();
		for (int i = 0; i < vAgente.length; i++) {
			if(vAgente[i] != null && valor>=vAgente[i].getSalario()) {
				System.out.println(vAgente[i].toString());
			}
		}
	}
	
	public static void main(String[] args) {
		int opcion=0;
		Menu menu = new Menu();
		Agentes[] vAgente = new Agentes[10];
		do {
			opcion = menu.pintaMenu();
			switch (opcion) {
			case 1:
				for (Agentes agentes : vAgente) {
					if(agentes!=null) {
						System.out.println(agentes.toString());
					}
				}
				break;
			case 2:
				salarioMayorQue(vAgente);
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			case 6:
				
				break;
			case 7:
				
				break;
			case 8:
				System.out.println("Saliendo");
				break;
			}
		}while(opcion!=8);
	}
	
}
