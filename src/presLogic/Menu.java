package presLogic;

import java.util.ArrayList;
import obj.Player;
import all.PlayerNotFoundException;
import bizLogic.*;

public class Menu {
	Manager mng = new Manager();
	
	public String mainMenu(){
		String mainMsg = "Bienvenido al bot de agentes libres de BasketballReasons\nSelecciona una opción:\n /1 Lista completa de FAs\n /2 FAs por posición\n /3 Buscar FA por nombre";
		return mainMsg;
	}

	public String complListMenu(ArrayList<Player> players){
		StringBuffer buf = new StringBuffer();
		for(Player aux:players){
			buf.append(aux.toString()+"\n");
		}
		String list = buf.toString();
		return list;
	}
	
	public String posListMenu(ArrayList<Player> players, String pos){
		players = mng.getPlayersByPosition(pos, players);
		StringBuffer buf = new StringBuffer();
		for(Player aux:players){
			buf.append(aux.toString()+"\n");
		}
		String list = buf.toString();
		return list;
	}
	public String searchNameMenu(String name, ArrayList<Player> players){
		StringBuffer buf = new StringBuffer();
		String result = "";
		Player player = new Player();
		try {
			player = mng.getPlayerByName(name, players);
			buf.append(player.toString());
			buf.append("\nIN"+ " OUT"+" HAN"+ " DEF"+ " REB");
			buf.append("\n"+player.getAbs());
			result = buf.toString();
			return result;
		} catch (PlayerNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("hey");
			return e.getMessage();
		}
		
	}
}
