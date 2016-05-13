package presLogic;

import java.util.ArrayList;
import java.util.Scanner;

import obj.Player;
import bizLogic.*;

public class Menu {
	Manager mng = new Manager();
	
	public void principalMenu(){
		System.out.println("Bienvenido al bot de agentes libres de BasketballReasons");
		System.out.println("Selecciona tu opción:");
		System.out.println("1.- Lista completa de agentes libres");
		System.out.println("2.- Lista de FAs por posición");
		System.out.println("3.- Buscar FA por nombre");
		System.out.println("4.- Salir");
	}

	public void complListMenu(){
		ArrayList<Player> players = new ArrayList<Player>();
		players = mng.getPlayerList();
		for(Player aux:players){
			System.out.println(aux.toString());
		}
	}
	public void posListMenu(){
		ArrayList<Player> players = new ArrayList<Player>();
		Scanner scan = new Scanner(System.in);
		System.out.println("Qué posición quieres buscar?");
		String pos = scan.nextLine();
		players = mng.getPlayersByPosition(pos);
		for(Player aux:players){
			System.out.println(aux.toString());
		}
	}
	public void searchNameMenu(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce el nombre del jugador que quieres buscar");
		String name = scan.nextLine();
		Player player = mng.getPlayerByName(name);
		if(player.getName()==null){
			System.out.println("No se han encontrado coincidencias");
		} else{
			System.out.println(player.toString());
			System.out.println("IN"+ " OUT"+" HAN"+ " DEF"+ " REB");
			System.out.println(player.getAbs());
		}
	}
}
