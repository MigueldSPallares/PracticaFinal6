package main;

import java.util.Scanner;

public class Menu {
	
	public int pintaMenu() {
		int opc = 0;
		Scanner leer = new Scanner (System.in);
		//Aqu� se crea un men� que solo admite valores entre el 1 y el 8
		do {
			try {
				System.out.println("1- Ver todos los agentes con su informaci�n");
				System.out.println("2- Ver los agentes que ganen m�s de una cantidad X");
				System.out.println("3- Dar de alta un nuevo piso");
				System.out.println("4- Dar de alta una nueva arma");
				System.out.println("5- Dar de alta un nuevo agente");
				System.out.println("6- Encriptar toda la informaci�n");
				System.out.println("7- Desencriptar toda la informaci�n");
				System.out.println("8- Salir");
				opc = leer.nextInt();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}while(opc<1 || opc>8);
		return opc;
	}
}
