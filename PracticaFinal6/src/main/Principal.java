package main;

import java.util.Scanner;

import agentes.Agente007;
import agentes.Agentes;
import agentes.Espionaje;
import agentes.Jefazo;

public class Principal {
	
	public static void salarioMayorQue(Agentes[] vAgente) {
		Scanner leer = new Scanner(System.in);
		double valor;
		System.out.println("Pon un número y te mostraré los agentes que ganan más que ese valor");
		valor = leer.nextDouble();
		for (int i = 0; i < vAgente.length; i++) {
			if(vAgente[i] != null && valor<=vAgente[i].getSalario()) {
				System.out.println(vAgente[i].toString());
			}
		}
	}
	
	public static void nuevoAgente(Agentes[] vAgente) {
		Scanner leer = new Scanner(System.in);
		
		Menu menu = new Menu();
		String nombre, direccion;
		int edad, añosMandato, numMuertos, opc;
		double salario;
		System.out.println("Pon el nombre del agente");
		nombre = leer.nextLine();
		System.out.println("Pon la edad del agente");
		leer = new Scanner(System.in);
		edad = leer.nextInt();
		System.out.println("Pon la dirección del agente");
		leer = new Scanner(System.in);
		direccion = leer.nextLine();
		System.out.println("Pon el salario del agente");
		leer = new Scanner(System.in);
		salario = leer.nextDouble();
		System.out.println("¿Qué tipo de agente es?");
		opc = menu.pintaMenu2();
		//Se decide qué tipo de agente es
		switch(opc) {
		case 1:
			System.out.println("Pon los años que está en mandato");
			leer = new Scanner(System.in);
			añosMandato = leer.nextInt();
			Jefazo ag1 = new Jefazo(nombre, edad, direccion, salario, añosMandato);
			for (int i = 0; i < vAgente.length; i++) {
				if(vAgente[i]==null) {
					vAgente[i] = ag1;
					break;
				}
			}
			break;
		case 2:
			Espionaje ag2 = new Espionaje(nombre, edad, direccion, salario);
			for (int i = 0; i < vAgente.length; i++) {
				if(vAgente[i]==null) {
					vAgente[i] = ag2;
					break;
				}
			}
			break;
		case 3:
			System.out.println("Pon el número de muertos");
			leer = new Scanner(System.in);
			numMuertos = leer.nextInt();
			Agente007 ag3 = new Agente007(nombre, edad, direccion, salario, numMuertos);
			for (int i = 0; i < vAgente.length; i++) {
				if(vAgente[i]==null) {
					vAgente[i] = ag3;
					break;
				}
			}
			break;
		}
	}
	
	public static void main(String[] args) {
		
		IODatos iodatos = new IODatos();
		int opcion=0;
		boolean encriptado = false;
		Menu menu = new Menu();
		Agentes[] vAgente = new Agentes[10];
		
		do {
			opcion = menu.pintaMenu();
			switch (opcion) {
			case 1:
				if(!encriptado) {
					for (Agentes agentes : vAgente) {
						if(agentes!=null) {
							System.out.println(agentes.toString());
						}
					}
				}else {
					System.out.println("El programa está encriptado");
				}
				break;
			case 2:
				if(!encriptado) {
					salarioMayorQue(vAgente);
				}else {
					System.out.println("El programa está encriptado");
				}
				break;
			case 3:
				if(!encriptado) {
					iodatos.guardarPiso();
				}else {
					System.out.println("El programa está encriptado");
				}
				break;
			case 4:
				if(!encriptado) {
					iodatos.guardarArma();
				}else {
					System.out.println("El programa está encriptado");
				}
				break;
			case 5:
				if(!encriptado) {
					nuevoAgente(vAgente);
				}else {
					System.out.println("El programa está encriptado");
				}
				break;
			case 6:
				if(!encriptado) {
					iodatos.encriptar(vAgente);
				}else {
					System.out.println("El programa está encriptado");
				}
				encriptado = true;
				break;
			case 7:
				if(encriptado) {
					iodatos.desencriptar(vAgente);
				}else {
					System.out.println("El programa no está encriptado");
				}
				encriptado = false;
				break;
			case 8:
				System.out.println("Saliendo");
				break;
			}
		}while(opcion!=8);
	}
	
}
