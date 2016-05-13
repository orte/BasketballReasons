package main;

import java.util.Scanner;
import presLogic.Menu;

public class Main {

	public static void main(String[] args) {

		Menu menus = new Menu();
		int opcion = 0;
		Scanner scan = new Scanner(System.in);
		while(opcion!=4){
			menus.principalMenu();
			opcion = scan.nextInt();
			switch(opcion){
			case 1: menus.complListMenu(); break;
			case 2: menus.posListMenu(); break;
			case 3: menus.searchNameMenu(); break;
			case 4: System.out.println("Hasta luego!"); break;
			}
		}
		scan.close();
	}

}
